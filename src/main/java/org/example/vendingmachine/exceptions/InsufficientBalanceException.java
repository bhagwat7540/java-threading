package org.example.vendingmachine.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(int price, int availableBalance) {
        super("Current item price is - " + price + "money added is - " + availableBalance);
    }
}
