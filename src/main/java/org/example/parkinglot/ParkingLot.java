package org.example.parkinglot;

import org.example.parkinglot.exceptions.InvalidTicketException;
import org.example.parkinglot.exceptions.LotFullException;
import org.example.parkinglot.exceptions.PaymentFailedException;
import org.example.parkinglot.model.*;
import org.example.parkinglot.strategies.PaymentStrategy;
import org.example.parkinglot.strategies.PricingStrategy;
import org.example.parkinglot.strategies.SpotAllocationStrategy;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ParkingLot {
    private final List<ParkingFloor> floors = new CopyOnWriteArrayList<>();
    private final SpotAllocationStrategy allocator;
    private final PricingStrategy pricing;
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private final Map<String, ParkingSpot> spotIndex = new ConcurrentHashMap<>();
    private final AtomicLong ticketSeq = new AtomicLong(1000);

    public ParkingLot(SpotAllocationStrategy allocator, PricingStrategy pricing) {
        this.allocator = allocator;
        this.pricing = pricing;
    }
    public void addFloor(ParkingFloor floor, List<ParkingSpot> spots) {
        for (ParkingSpot s : spots) {
            floor.addSpot(s);
            spotIndex.put(s.getSpotId(), s);
        }

        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = allocator.findAndClaim(floors, vehicle);
        if (spot == null) throw new LotFullException(vehicle.getVehicleType());
        Ticket ticket = new Ticket("T-" + ticketSeq.incrementAndGet(), vehicle, spot.getSpotId(), Instant.now());
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public Receipt unparkVehicle(String ticketId, PaymentStrategy payment) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) throw new InvalidTicketException(ticketId);
        Instant now = Instant.now();
        int fee = pricing.calculate(ticket, now);
        if (!payment.pay(fee)) throw new PaymentFailedException(ticketId, fee);
        activeTickets.remove(ticketId);
        ParkingSpot spot = spotIndex.get(ticket.getSpotId());
        for (ParkingFloor f : floors) {
            if (spotOnFloor(f, spot)) { f.release(spot); break; }
        }
        return new Receipt(ticketId, fee, now);
    }

    private boolean spotOnFloor(ParkingFloor f, ParkingSpot s) {
        return s.getSpotId().startsWith("F" + f.getFloorNumber() + "-");
    }

}
