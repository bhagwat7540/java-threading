package org.example.coffeemachine.beverage;

import org.example.coffeemachine.model.Ingredient;

import java.util.Map;

public class ExtraMilk extends BeverageDecorator{
    public ExtraMilk(Beverage beverageInner) {
        super(beverageInner);
    }

    @Override
    public Map<Ingredient, Integer> needs() {
        Map<Ingredient, Integer> need = beverageInner.needs();
        need.merge(Ingredient.MILK, 30, Integer::sum);
        return need;
    }

    @Override
    public int cost() {
        return this.beverageInner.cost() + 20;
    }

    @Override
    public String description() {
        return beverageInner.description() + " Extra Milk";
    }
}
