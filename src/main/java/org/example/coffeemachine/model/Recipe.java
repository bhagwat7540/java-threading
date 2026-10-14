package org.example.coffeemachine.model;

import java.util.Map;

public class Recipe {
    private final Map<Ingredient, Integer> needs;
    private final int price;

    public Recipe(Map<Ingredient, Integer> needs, int price) {
        this.needs = needs;
        this.price = price;
    }

    public Map<Ingredient, Integer> getNeeds() {
        return needs;
    }

    public int getPrice() {
        return price;
    }
}
