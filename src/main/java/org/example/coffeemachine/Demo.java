package org.example.coffeemachine;

import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;
import org.example.coffeemachine.model.Ingredient;
import org.example.coffeemachine.model.Recipe;

import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.getBook().add(DrinkType.CAPPUCINO, new Recipe(Map.of(Ingredient.MILK,1, Ingredient.BEAN, 18), 15));
        machine.refill(Ingredient.MILK, 100);
        machine.refill(Ingredient.BEAN, 50);

        machine.insertMoney(200);
        machine.selectDrink(DrinkType.CAPPUCINO, List.of(AddOns.EXTRA_MILK));
        // Brewing: CAPPUCCINO + extra milk, Change: 60, back to Idle
    }
}
