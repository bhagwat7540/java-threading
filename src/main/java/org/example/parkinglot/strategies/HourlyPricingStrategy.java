package org.example.parkinglot.strategies;

import org.example.parkinglot.model.Ticket;
import org.example.parkinglot.model.VehicleType;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final Map<VehicleType, Integer> RATE = Map.of(
            VehicleType.BIKE, 100,
            VehicleType.CAR, 200,
            VehicleType.TRUCK, 400
    );

    @Override
    public int calculate(Ticket ticket, Instant exitTime) {
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        long hours = Math.max(1, (minutes + 59) / 60);        // round up, minimum 1
        return (int) hours * RATE.get(ticket.getVehicle().getVehicleType());
    }
}
