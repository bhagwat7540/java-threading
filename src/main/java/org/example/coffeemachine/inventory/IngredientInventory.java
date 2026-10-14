package org.example.coffeemachine.inventory;

import org.example.coffeemachine.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventory {
    Map<Ingredient, Integer> stock = new HashMap<>();

    public synchronized boolean tryReserve(Map<Ingredient, Integer> needs) {
        for(Ingredient ingredient : needs.keySet()) {
            if(stock.getOrDefault(ingredient, 0) < needs.get(ingredient)) return false;
        }

        for(Ingredient ingredient : needs.keySet()) {
            stock.merge(ingredient, -needs.get(ingredient), Integer::sum);
        }
        return true;
    }

    public synchronized void release(Map<Ingredient, Integer> needs) {
        for(Ingredient ingredient : needs.keySet()) {
            stock.merge(ingredient, needs.get(ingredient), Integer::sum);
        }
    }

    public synchronized void refill(Ingredient ingredient, int qty) {
        stock.merge(ingredient, qty, Integer::sum);
    }

    public synchronized int level(Ingredient i) { return stock.getOrDefault(i, 0); }

}
