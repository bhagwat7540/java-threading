package org.example.vendingmachine.state;

import org.example.vendingmachine.VendingMachine;
import org.example.vendingmachine.enums.Coin;

public class IdleState implements State{
    @Override
    public void insertMoney(VendingMachine machine, Coin coin) {
        machine.addBalance(coin);
        machine.setState(new HasMoneyState());
    }

    @Override
    public void selectItem(VendingMachine machine, String code) {
        throw new IllegalStateException("Insert money first");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        throw new IllegalStateException("Insert money first");
    }

    @Override
    public void refund(VendingMachine machine) {
        throw new IllegalStateException("Insert money first");
    }
}
