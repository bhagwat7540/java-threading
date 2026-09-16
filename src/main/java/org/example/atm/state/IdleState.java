package org.example.atm.state;

import org.example.atm.Atm;
import org.example.atm.exceptions.CardExpiredException;
import org.example.atm.model.Card;

public class IdleState implements AtmState{
    public void insertCard(Atm atm, Card card) {
        if (card.isExpired()) throw new CardExpiredException();
        atm.setCard(card);
        atm.setState(new CardInsertedState());
    }
    public void enterPin(Atm atm, String pin) { throw new IllegalStateException("Insert a card first"); }
    public void withdraw(Atm atm, int amount) { throw new IllegalStateException("Insert a card first"); }
    public void checkBalance(Atm atm) { throw new IllegalStateException("Insert a card first"); }
    public void ejectCard(Atm atm) { throw new IllegalStateException("No card inside"); }
}
