package org.example.atm.bank;

import org.example.atm.model.Card;

public interface BankService {
    public boolean verifyPin(Card card, String pin);
    public int getBalance(String accountId);
    public void debit(String accountId, int amount);
    public void credit(String accountId, int amount);
}
