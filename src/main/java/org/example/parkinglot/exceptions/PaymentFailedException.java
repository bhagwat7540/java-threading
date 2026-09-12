package org.example.parkinglot.exceptions;

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String ticketId, int amount) {
        super("Payment failed for - " + ticketId + " , amount not sent - " + amount);
    }
}
