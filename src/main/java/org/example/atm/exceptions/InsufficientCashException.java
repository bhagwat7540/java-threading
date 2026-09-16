package org.example.atm.exceptions;

public class InsufficientCashException extends RuntimeException{
    public InsufficientCashException() {
        super("Insufficient Cash");
    }
}
