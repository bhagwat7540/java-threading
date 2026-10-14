package org.example.coffeemachine.beverage;

import org.example.coffeemachine.model.Ingredient;

import java.util.Map;

public class ExtraSugar extends BeverageDecorator{

    public ExtraSugar(Beverage beverageInner) {
        super(beverageInner);
    }

    @Override
    public Map<Ingredient, Integer> needs() {
        Map<Ingredient, Integer> need = beverageInner.needs();
        need.merge(Ingredient.SUGAR, 5, Integer::sum);
        return need;
    }

    @Override
    public int cost() {
        return beverageInner.cost() + 10;
    }

    @Override
    public String description() {
        return beverageInner.description() + " Extra Sugar";
    }
}
