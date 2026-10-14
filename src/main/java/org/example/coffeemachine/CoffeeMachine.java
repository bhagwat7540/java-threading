package org.example.coffeemachine;

import org.example.coffeemachine.beverage.Beverage;
import org.example.coffeemachine.inventory.IngredientInventory;
import org.example.coffeemachine.model.AddOns;
import org.example.coffeemachine.model.DrinkType;
import org.example.coffeemachine.model.Ingredient;
import org.example.coffeemachine.model.RecipeBook;
import org.example.coffeemachine.state.IdleState;
import org.example.coffeemachine.state.MachineState;

import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private MachineState state = new IdleState();
    private final IngredientInventory inventory = new IngredientInventory();
    private final RecipeBook book = new RecipeBook();
    private int balance;
    private Beverage pending;
    private Map<Ingredient, Integer> pendingNeeds;

    public void insertMoney(int amt) { state.insertMoney(this, amt); }
    public void selectDrink(DrinkType t, List<AddOns> a) { state.selectDrink(this, t, a); }
    public void dispense() { state.dispense(this); }
    public void refund() { state.refund(this); }

    public void refill(Ingredient i, int units) { inventory.refill(i, units); }


    public void setState(MachineState s) { state = s; }
    public void addBalance(int a) { balance += a; }
    public int getBalance() { return balance; }
    public IngredientInventory getInventory() { return inventory; }
    public RecipeBook getBook() { return book; }
    public void setPending(Beverage b, Map<Ingredient, Integer> needs) { pending = b; pendingNeeds = needs; }
    public int getPendingCost() { return pending.cost(); }
    public Map<Ingredient, Integer> getPendingNeeds() { return pendingNeeds; }
    public void brewHardware() { System.out.println("Brewing: " + pending.description()); }
    public void giveChange(int c) { if (c > 0) System.out.println("Change: " + c); }
    public void refundBalance() { System.out.println("Refund: " + balance); balance = 0; }
    public void reset() { balance = 0; pending = null; pendingNeeds = null; }

}
