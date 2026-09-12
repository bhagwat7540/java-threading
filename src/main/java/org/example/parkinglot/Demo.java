package org.example.parkinglot;

import org.example.parkinglot.model.*;
import org.example.parkinglot.strategies.CardPayment;
import org.example.parkinglot.strategies.HourlyPricingStrategy;
import org.example.parkinglot.strategies.NearestFirstStrategy;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(new NearestFirstStrategy(), new HourlyPricingStrategy());

        ParkingFloor f1 = new ParkingFloor(1);
        lot.addFloor(f1, List.of(
                new ParkingSpot("F1-S1", SpotType.SMALL),
                new ParkingSpot("F1-C1", SpotType.COMPACT),
                new ParkingSpot("F1-L1", SpotType.LARGE)
        ));

        Vehicle car = VehicleFactory.create(VehicleType.CAR, "KA-01-1234");
        Ticket ticket = lot.parkVehicle(car);
        System.out.println("Parked at " + ticket.getSpotId());

        Receipt receipt = lot.unparkVehicle(ticket.getTicketId(), new CardPayment());
        System.out.println("Paid " + receipt.getAmount() + " cents");
    }
}