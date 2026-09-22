package org.example.vendingmachine.money;

import org.example.vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashDispenser {
    private final Map<Coin, Integer> coinMap = new HashMap<>();

    public synchronized void add(Coin coin, Integer qty) {
        coinMap.put(coin, coinMap.getOrDefault(coin, 0)+qty);
    }

    public synchronized boolean canChange(int amount) {
        return tryPlan(amount) != null;
    }

    public synchronized List<Coin> makeChange(int amount) {
        List<Coin> plan = tryPlan(amount);
        if (plan == null) throw new IllegalStateException("Cannot make change for " + amount);
        for (Coin c : plan) coinMap.merge(c, -1, Integer::sum);
        return plan;
    }

    private List<Coin> tryPlan(int amount) {
        List<Coin> list = new ArrayList<>();
        Coin[] byValueDescendingOrder = { Coin.ONE, Coin.QUARTER, Coin.DIME, Coin.NICKEL, Coin.PENNY };
        for(Coin coin : byValueDescendingOrder) {
            int available = coinMap.getOrDefault(coin, 0);
            while(amount >= coin.getValue() && available >= 0) {
                list.add(coin);
                amount -= coin.getValue();
                available--;
            }
        }

        return amount == 0 ? list : null;
    }


}
