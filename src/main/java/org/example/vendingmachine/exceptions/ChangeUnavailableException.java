package org.example.vendingmachine.exceptions;

public class ChangeUnavailableException extends RuntimeException{
    public ChangeUnavailableException() {
        super("Change not available");
    }
}
