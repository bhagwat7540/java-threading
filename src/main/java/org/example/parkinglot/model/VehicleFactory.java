package org.example.parkinglot.model;

public class VehicleFactory {
    public static Vehicle create(VehicleType type, String plateNumber){
        switch (type) {
            case BIKE : return new Bike(plateNumber);
            case CAR : return new Car(plateNumber);
            case TRUCK : return new Truck(plateNumber);
            default : throw new IllegalArgumentException("Unknown Type - " + type);
        }
    }
}
