package org.example.atm.bank;

import org.example.atm.model.Card;

public class MockBankService implements BankService{
    @Override
    public boolean verifyPin(Card card, String pin) {
        return true;
    }

    @Override
    public int getBalance(String accountId) {
        return 200000;
    }

    @Override
    public synchronized void debit(String accountId, int amount) {
        System.out.println("Debited");
    }

    @Override
    public synchronized void credit(String accountId, int amount) {
        System.out.println("Credited");
    }
}
