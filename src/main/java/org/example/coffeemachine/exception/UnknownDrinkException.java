package org.example.coffeemachine.exception;

public class UnknownDrinkException extends RuntimeException {
    public UnknownDrinkException() {
        super("Invalid drink type provided");
    }
}
