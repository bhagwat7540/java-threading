package org.example.coffeemachine.beverage;

import org.example.coffeemachine.model.DrinkType;
import org.example.coffeemachine.model.Ingredient;
import org.example.coffeemachine.model.Recipe;

import java.util.HashMap;
import java.util.Map;

public class BaseBeverage implements Beverage{
    private final DrinkType type;
    private final Recipe recipe;

    public BaseBeverage(DrinkType type, Recipe recipe) {
        this.type = type;
        this.recipe = recipe;
    }

    @Override
    public Map<Ingredient, Integer> needs() {
        return new HashMap<>(recipe.getNeeds());
    }

    @Override
    public int cost() {
        return recipe.getPrice();
    }

    @Override
    public String description() {
        return type.name();
    }
}
