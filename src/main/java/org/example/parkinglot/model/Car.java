package org.example.parkinglot.model;

public class Car extends Vehicle{
    public Car(String plateNumber) {
        super(plateNumber, VehicleType.CAR);
    }
}
