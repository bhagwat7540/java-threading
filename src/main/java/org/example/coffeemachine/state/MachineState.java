package org.example.coffeemachine.state;

import org.example.coffeemachine.CoffeeMachine;
import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;

import java.util.List;

public interface MachineState {
    void insertMoney(CoffeeMachine m, int amount);
    void selectDrink(CoffeeMachine m, DrinkType t, List<AddOns> ad);
    void dispense(CoffeeMachine m);
    void refund(CoffeeMachine m);
}
