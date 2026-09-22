package org.example.vendingmachine.state;

import org.example.vendingmachine.VendingMachine;
import org.example.vendingmachine.enums.Coin;
import org.example.vendingmachine.exceptions.OutOfStockException;
import org.example.vendingmachine.model.ItemShelf;

import java.util.List;

public class DispenseState implements State{

    public void insertMoney(VendingMachine machine, Coin coin) {
        throw new IllegalStateException("Dispensing in progress");
    }
    public void selectItem(VendingMachine machine, String code) {
        throw new IllegalStateException("Already dispensing");
    }

    public void dispenseItem(VendingMachine machine) {
        ItemShelf shelf = machine.getInventory().getShelf(machine.getSelected());

        if (!shelf.tryDispense()) {
            machine.refundBalance();
            machine.setState(new IdleState());
            throw new OutOfStockException(machine.getSelected());
        }
        int change = machine.getBalance() - shelf.getItem().getPrice();
        List<Coin> coins = machine.getDispenser().makeChange(change);
        machine.deliver(shelf.getItem(), coins);
        machine.reset();
        machine.setState(new IdleState());
    }
    public void refund(VendingMachine machine) {
        machine.refundBalance();
        machine.setState(new IdleState());
    }
}
