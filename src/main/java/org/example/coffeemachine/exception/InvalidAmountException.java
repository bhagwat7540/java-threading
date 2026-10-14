package org.example.coffeemachine.exception;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException() {
        super("Enter amount > 0");
    }
}
