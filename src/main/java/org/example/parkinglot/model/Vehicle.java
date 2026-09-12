package org.example.parkinglot.model;

public abstract class Vehicle {
    private final String plateNumber;
    private final VehicleType vehicleType;

    public Vehicle(String plateNumber, VehicleType type) {
        this.plateNumber = plateNumber;
        this.vehicleType = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
