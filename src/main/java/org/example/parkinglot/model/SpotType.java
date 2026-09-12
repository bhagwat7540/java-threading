package org.example.parkinglot.model;

public enum SpotType {
    SMALL,
    COMPACT,
    LARGE;

    public static SpotType[] comaptibleWith(VehicleType type) {
        switch (type) {
            case BIKE : return new SpotType[]{SMALL, COMPACT, LARGE};
            case CAR : return new SpotType[]{COMPACT, LARGE};
            case TRUCK : return new SpotType[]{LARGE};
            default : throw new IllegalArgumentException("Unknown Type - " + type);
        }
    }
}
