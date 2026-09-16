package org.example.atm.cash;

import org.example.atm.exceptions.InsufficientCashException;

import java.util.HashMap;
import java.util.Map;

public class CashDispenser {
    private final NoteHandler chain;

    public CashDispenser(NoteHandler chain) {
        this.chain = chain;
    }

    public synchronized boolean canDispense(int amount) {
        return amount > 0 && amount % 100 == 0 && chain.plan(amount, new HashMap<>());
    }

    public synchronized Map<Integer, Integer> dispense(int amount) {
        Map<Integer, Integer> plan = new HashMap<>();
        if (!chain.plan(amount, plan)) throw new InsufficientCashException();
        chain.commit(plan);
        return plan;
    }
}
