package org.example.coffeemachine.model;

import org.example.coffeemachine.exception.UnknownDrinkException;

import java.util.HashMap;
import java.util.Map;

public class RecipeBook {
    private final Map<DrinkType, Recipe> map = new HashMap<>();

    public void add(DrinkType type, Recipe recipe) {
        map.put(type, recipe);
    }

    public Recipe recipeFor(DrinkType type) {
        if(!map.containsKey(type)) {
            throw new UnknownDrinkException();
        }

        return map.get(type);
    }
}
