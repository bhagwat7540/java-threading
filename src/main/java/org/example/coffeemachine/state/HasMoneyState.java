package org.example.coffeemachine.state;

import org.example.coffeemachine.CoffeeMachine;
import org.example.coffeemachine.beverage.BaseBeverage;
import org.example.coffeemachine.beverage.Beverage;
import org.example.coffeemachine.beverage.ExtraMilk;
import org.example.coffeemachine.beverage.ExtraSugar;
import org.example.coffeemachine.exception.IngredientUnavailableException;
import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;
import org.example.coffeemachine.model.Ingredient;
import org.example.vendingmachine.exceptions.InsufficientBalanceException;

import java.util.List;
import java.util.Map;

public class HasMoneyState implements MachineState{
    public void insertMoney(CoffeeMachine m, int amount) {
        m.addBalance(amount);
    }

    public void selectDrink(CoffeeMachine m, DrinkType type, List<AddOns> addons) {
        Beverage b = new BaseBeverage(type, m.getBook().recipeFor(type));
        for (AddOns a : addons) b = decorate(b, a);
        if (m.getBalance() < b.cost())
            throw new InsufficientBalanceException(b.cost(), m.getBalance());
        Map<Ingredient, Integer> needs = b.needs();
        if (!m.getInventory().tryReserve(needs)) throw new IngredientUnavailableException();
        m.setPending(b, needs);
        m.setState(new BrewingState());
        m.dispense();
    }

    private Beverage decorate(Beverage b, AddOns a) {
        switch (a) {
            case EXTRA_MILK:  return new ExtraMilk(b);
            case EXTRA_SUGAR: return new ExtraSugar(b);
            default: throw new IllegalArgumentException(a.name());
        }
    }

    public void dispense(CoffeeMachine m) {
        throw new IllegalStateException("Select a drink first");
    }

    public void refund(CoffeeMachine m) {
        m.refundBalance();
        m.setState(new IdleState());
    }
}
