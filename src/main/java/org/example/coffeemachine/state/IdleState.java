package org.example.coffeemachine.state;

import org.example.coffeemachine.CoffeeMachine;
import org.example.coffeemachine.exception.InvalidAmountException;
import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;

import java.util.List;

public class IdleState implements MachineState{
    public void insertMoney(CoffeeMachine m, int amount) {
        if(amount <= 0) throw new InvalidAmountException();

        m.addBalance(amount);
        m.setState(new HasMoneyState());
    }

    public void selectDrink(CoffeeMachine m, DrinkType t, List<AddOns> ad) {
        throw new IllegalStateException("Insert Money first");
    }

    public void dispense(CoffeeMachine m) {
        throw new IllegalStateException("Insert Money first");
    }

    public void refund(CoffeeMachine m) {
        throw new IllegalStateException("Insert Money first");
    }
}
