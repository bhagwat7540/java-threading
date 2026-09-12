package org.example.parkinglot.model;

import java.time.Instant;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final String spotId;
    private final Instant entryTime;

    public Ticket(String ticketId, Vehicle vehicle, String spotId, Instant entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSpotId() {
        return spotId;
    }

    public Instant getEntryTime() {
        return entryTime;
    }
}
