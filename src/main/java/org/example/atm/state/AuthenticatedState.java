package org.example.atm.state;

import org.example.atm.Atm;
import org.example.atm.exceptions.InsufficientCashException;
import org.example.atm.exceptions.InvalidAmountException;
import org.example.atm.model.Card;

public class AuthenticatedState implements AtmState{
    public void insertCard(Atm atm, Card card) { throw new IllegalStateException("Session in progress"); }
    public void enterPin(Atm atm, String pin) { throw new IllegalStateException("Already authenticated"); }

    public void withdraw(Atm atm, int amount) {
        if (amount <= 0 || amount % 100 != 0) throw new InvalidAmountException(amount);
        if (!atm.getDispenser().canDispense(amount)) throw new InsufficientCashException();

        atm.getBank().debit(atm.getCard().getAccountId(), amount);
        atm.setPendingAmount(amount);
        atm.setState(new DispensingState());
        atm.dispense();
    }
    public void checkBalance(Atm atm) {
        long bal = atm.getBank().getBalance(atm.getCard().getAccountId());
        atm.display("Balance: " + bal);
    }
    public void ejectCard(Atm atm) { atm.returnCard(); atm.setState(new IdleState()); }
}
