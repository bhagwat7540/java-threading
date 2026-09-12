package org.example.parkinglot.strategies;

import org.example.parkinglot.model.ParkingFloor;
import org.example.parkinglot.model.ParkingSpot;
import org.example.parkinglot.model.Vehicle;

import java.util.List;

public class NearestFirstStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot findAndClaim(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAndClaim(vehicle.getVehicleType(), vehicle);
            if (spot != null) return spot;
        }
        return null;
    }
}
