package org.example.vendingmachine.state;

import org.example.vendingmachine.VendingMachine;
import org.example.vendingmachine.enums.Coin;

public interface State {
    void insertMoney(VendingMachine machine, Coin coin);
    void selectItem(VendingMachine machine, String code);
    void dispenseItem(VendingMachine machine);
    void refund(VendingMachine machine);
}
