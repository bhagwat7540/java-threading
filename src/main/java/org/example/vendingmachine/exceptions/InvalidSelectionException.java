package org.example.vendingmachine.exceptions;

public class InvalidSelectionException extends RuntimeException{
    public InvalidSelectionException(String code) {
        super("Item with " + code + " not present");
    }
}
