package org.example.parkinglot.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private AtomicBoolean occupied = new AtomicBoolean(false);
    private volatile Vehicle vehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean tryOccupy(Vehicle vehicle) {
        if(occupied.compareAndSet(false, true)) {
            this.vehicle = vehicle;
            return true;
        }

        return false;
    }

    public void vacate() {
        this.vehicle = null;
        occupied.set(false);
    }
}
