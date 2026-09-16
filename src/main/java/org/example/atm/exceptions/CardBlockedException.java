package org.example.atm.exceptions;

public class CardBlockedException extends RuntimeException{
    public CardBlockedException() {
        super("More than 3 tries resulted in card blocked");
    }
}
