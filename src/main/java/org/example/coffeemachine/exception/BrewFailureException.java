package org.example.coffeemachine.exception;

public class BrewFailureException extends RuntimeException {
    public BrewFailureException() {
        super("Coffee brew failed");
    }
}
