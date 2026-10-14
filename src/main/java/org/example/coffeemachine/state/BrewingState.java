package org.example.coffeemachine.state;

import org.example.coffeemachine.CoffeeMachine;
import org.example.coffeemachine.exception.BrewFailureException;
import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;

import java.util.List;

public class BrewingState implements MachineState {
    public void insertMoney(CoffeeMachine m, int amount) {
        throw new IllegalStateException("Brewing");
    }

    public void selectDrink(CoffeeMachine m, DrinkType t, List<AddOns> ad) {
        throw new IllegalStateException("Brewing");
    }

    public void refund(CoffeeMachine m) {
        throw new IllegalStateException("Brewing");
    }

    public void dispense(CoffeeMachine m) {
        try {
            m.brewHardware();
            m.giveChange(m.getBalance() - m.getPendingCost());
        } catch (BrewFailureException e) {
            m.getInventory().release(m.getPendingNeeds());
            m.refundBalance();
        } finally {
            m.reset();
            m.setState(new IdleState());
        }
    }
}


