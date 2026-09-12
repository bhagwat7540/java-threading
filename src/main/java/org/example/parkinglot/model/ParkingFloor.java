package org.example.parkinglot.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<SpotType, Queue<ParkingSpot>> freeSpots = new HashMap<>();

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        for(SpotType type : SpotType.values()) {
            freeSpots.put(type, new ConcurrentLinkedQueue<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        freeSpots.get(spot.getSpotType()).add(spot);
    }

    public ParkingSpot findAndClaim(VehicleType vehicleType, Vehicle vehicle) {
        for(SpotType spotType : SpotType.comaptibleWith(vehicleType)) {
            Queue<ParkingSpot> queue = freeSpots.get(spotType);
            while(!queue.isEmpty()) {
                ParkingSpot spot = queue.poll();
                if(spot.tryOccupy(vehicle)) return spot;
            }
        }

        return null;
    }

    public void release(ParkingSpot spot) {
        spot.vacate();
        addSpot(spot);
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }
}
