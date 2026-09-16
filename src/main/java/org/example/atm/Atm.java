package org.example.atm;

import org.example.atm.bank.BankService;
import org.example.atm.cash.CashDispenser;
import org.example.atm.model.Card;
import org.example.atm.state.AtmState;
import org.example.atm.state.IdleState;

public class Atm {
    private org.example.atm.state.AtmState state = new IdleState();
    private final BankService bank;
    private final CashDispenser dispenser;
    private Card card;
    private int pendingAmount;

    public Atm(BankService bank, CashDispenser dispenser) {
        this.bank = bank; 
        this.dispenser = dispenser;
    }

    public void insertCard(Card c) { 
        state.insertCard(this, c); 
    }
    
    public void enterPin(String pin) {
        state.enterPin(this, pin);
    }

    public void withdraw(int amount) {
        state.withdraw(this, amount);
    }

    public void checkBalance() {
        state.checkBalance(this);
    }

    public void ejectCard() {
        state.ejectCard(this);
    }

    public void dispense() {
        state.ejectCard(this);
    }

    public void setState(AtmState s) {
        this.state = s;
    }

    public void setCard(Card c) {
        this.card = c;
    }

    public Card getCard() {
        return card;
    }

    public BankService getBank() {
        return bank;
    }

    public CashDispenser getDispenser() {
        return dispenser;
    }

    public void setPendingAmount(int a) {
        pendingAmount = a;
    }

    public int getPendingAmount() {
        return pendingAmount;
    }

    public void returnCard() {
        display("Card returned");
        card = null;
        pendingAmount = 0;
    }

    public void retainCard() {
        display("Card retained");
        card = null;
        pendingAmount = 0;
    }

    public void display(String msg) {
        System.out.println(msg);
    }
}