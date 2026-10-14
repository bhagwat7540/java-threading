package org.example.coffeemachine.beverage;

import org.example.coffeemachine.model.Ingredient;

import java.util.Map;

public interface Beverage {
    Map<Ingredient, Integer> needs();
    int cost();
    String description();
}
