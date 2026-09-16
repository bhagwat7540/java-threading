package org.example.atm.state;

import org.example.atm.Atm;
import org.example.atm.model.Card;

public interface AtmState {
    public void insertCard(Atm Atm, Card card);
    public void enterPin(Atm Atm, String pin);
    public void withdraw(Atm Atm, int amount);
    public void checkBalance(Atm Atm);
    public void ejectCard(Atm Atm);
}
