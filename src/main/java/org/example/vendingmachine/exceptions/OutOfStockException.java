package org.example.vendingmachine.exceptions;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException(String code) {
        super("No stock available for item having " + code);
    }
}
