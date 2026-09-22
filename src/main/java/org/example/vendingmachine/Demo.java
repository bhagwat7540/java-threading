package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;
import org.example.vendingmachine.model.Item;

public class Demo {
    public static void main(String[] args) {
        VendingMachine m = new VendingMachine();
        m.getInventory().addShelf("A1", new Item("A1", "Coke", 125), 3);
        m.refillCoins(Coin.QUARTER, 20);

        m.insertMoney(Coin.ONE);      // Idle -> HasMoney, balance 100
        m.insertMoney(Coin.ONE);      // balance 200
        m.selectItem("A1");           // validated -> Dispense
        m.dispense();                 // Coke out, change 75 as three quarters
    }
}
