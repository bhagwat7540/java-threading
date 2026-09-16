package org.example.atm.exceptions;

public class InvalidPinException extends RuntimeException{
    public InvalidPinException(int attempts) {
        super("Left Attempts - " + attempts);
    }
}
