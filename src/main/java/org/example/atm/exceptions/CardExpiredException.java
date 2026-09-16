package org.example.atm.exceptions;

public class CardExpiredException extends RuntimeException{
    public CardExpiredException() {
        super("Card has been expired");
    }
}
