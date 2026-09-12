package org.example.parkinglot.strategies;

import org.example.parkinglot.model.ParkingFloor;
import org.example.parkinglot.model.ParkingSpot;
import org.example.parkinglot.model.Vehicle;

import java.util.List;

public interface SpotAllocationStrategy {
    public ParkingSpot findAndClaim(List<ParkingFloor> parkingFloors, Vehicle vehicle);
}
