package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;
import org.example.vendingmachine.model.Inventory;
import org.example.vendingmachine.model.Item;
import org.example.vendingmachine.money.CashDispenser;
import org.example.vendingmachine.state.IdleState;
import org.example.vendingmachine.state.State;

import java.util.List;

public class VendingMachine {
    private State state = new IdleState();
    private int balance;
    private final Inventory inventory = new Inventory();
    private String selectCode;
    private final CashDispenser dispenser = new CashDispenser();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getBalance() {
        return balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getSelected() {
        return selectCode;
    }

    public void setSelected(String selectCode) {
        this.selectCode = selectCode;
    }

    public CashDispenser getDispenser() {
        return dispenser;
    }

    public void addBalance(Coin coin) {
        balance += coin.getValue();
        dispenser.add(coin, 1);
    }

    public void refundBalance() {
        dispenser.makeChange(balance);
        reset();
    }

    public void reset() {
        balance = 0;
        selectCode = null;
    }

    public void deliver(Item item, List<Coin> change) {
        if (item != null) System.out.println("Dispensed: " + item.getName());
        if (!change.isEmpty()) System.out.println("Change: " + change);
    }


    // buyer facing, all delegated to the current state
    public void insertMoney(Coin c) { state.insertMoney(this, c); }
    public void selectItem(String code) { state.selectItem(this, code); }
    public void dispense() { state.dispenseItem(this); }
    public void refund() { state.refund(this); }


    // operator facing
    public void restock(String code, int count) { inventory.getShelf(code).addStock(count); }
    public void refillCoins(Coin c, int count) { dispenser.add(c, count); }

}
