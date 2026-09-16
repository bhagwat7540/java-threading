package org.example.atm.state;

import org.example.atm.Atm;
import org.example.atm.model.Card;

import java.util.Map;

public class DispensingState implements AtmState {
    public void insertCard(Atm atm, Card card) { throw new IllegalStateException("Dispensing in progress"); }
    public void enterPin(Atm atm, String pin) { throw new IllegalStateException("Dispensing in progress"); }
    public void withdraw(Atm atm, int amount) { throw new IllegalStateException("Dispensing in progress"); }
    public void checkBalance(Atm atm) { throw new IllegalStateException("Dispensing in progress"); }
    public void ejectCard(Atm atm) {
        Map<Integer, Integer> notes = atm.getDispenser().dispense(atm.getPendingAmount());
        atm.display("Dispensed: " + notes);
        atm.returnCard();
        atm.setState(new IdleState());
    }
}