package org.example.parkinglot.model;

import java.time.Instant;

public final class Receipt {
    private final String ticketId;
    private final int amountInCents;
    private final Instant exitTime;
    public Receipt(String ticketId, int amountInCents, Instant exitTime) {
        this.ticketId = ticketId; this.amountInCents = amountInCents; this.exitTime = exitTime;
    }
    public int getAmount() { return amountInCents; }
}
