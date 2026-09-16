package org.example.atm.state;

import org.example.atm.Atm;
import org.example.atm.exceptions.CardBlockedException;
import org.example.atm.exceptions.InvalidPinException;
import org.example.atm.model.Card;

public class CardInsertedState implements AtmState{
    private int attempts = 0;

    @Override
    public void insertCard(Atm atm, Card card) {
        throw new IllegalArgumentException("Card already inserted");
    }

    @Override
    public void enterPin(Atm atm, String pin) {
        if (atm.getBank().verifyPin(atm.getCard(), pin)) {
            atm.setState(new AuthenticatedState());
            return;
        }
        attempts++;
        if (attempts >= 3) {                       // retain the card, protect the account
            atm.retainCard();
            atm.setState(new IdleState());
            throw new CardBlockedException();
        }
        throw new InvalidPinException(3 - attempts);
    }

    @Override
    public void withdraw(Atm atm, int amount) {
        throw new IllegalArgumentException("Enter Pin first");
    }

    @Override
    public void checkBalance(Atm atm) {
        throw new IllegalArgumentException("Enter Pin first");
    }

    @Override
    public void ejectCard(Atm atm) {
        throw new IllegalArgumentException("Enter Pin first");
    }
}
