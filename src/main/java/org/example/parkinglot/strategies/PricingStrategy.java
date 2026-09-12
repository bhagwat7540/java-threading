package org.example.parkinglot.strategies;

import org.example.parkinglot.model.Ticket;

import java.time.Instant;

public interface PricingStrategy {
    public int calculate(Ticket ticket, Instant exitTime);
}
