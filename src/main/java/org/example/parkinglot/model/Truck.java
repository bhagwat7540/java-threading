package org.example.parkinglot.model;

public class Truck extends Vehicle{
    public Truck(String plateNumber) {
        super(plateNumber, VehicleType.TRUCK);
    }
}
