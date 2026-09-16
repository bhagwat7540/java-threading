package org.example.atm.exceptions;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(int amount) {
        super("Invalid Amount "+ amount);
    }
}
