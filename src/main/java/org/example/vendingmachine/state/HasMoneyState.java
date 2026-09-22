package org.example.vendingmachine.state;

import org.example.vendingmachine.VendingMachine;
import org.example.vendingmachine.enums.Coin;
import org.example.vendingmachine.exceptions.ChangeUnavailableException;
import org.example.vendingmachine.exceptions.InsufficientBalanceException;
import org.example.vendingmachine.exceptions.InvalidSelectionException;
import org.example.vendingmachine.exceptions.OutOfStockException;
import org.example.vendingmachine.model.ItemShelf;

public class HasMoneyState implements State{
    @Override
    public void insertMoney(VendingMachine machine, Coin coin) {
        machine.addBalance(coin);
    }

    @Override
    public void selectItem(VendingMachine machine, String code) {
        ItemShelf shelf = machine.getInventory().getShelf(code);

        if (shelf == null) throw new InvalidSelectionException(code);
        if (!shelf.isAvailable()) throw new OutOfStockException(code);

        int price = shelf.getItem().getPrice();
        if (machine.getBalance() < price) throw new InsufficientBalanceException(price, machine.getBalance());

        if (!machine.getDispenser().canChange(machine.getBalance() - price)) throw new ChangeUnavailableException();
        machine.setSelected(code);
        machine.setState(new DispenseState());

    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        throw new IllegalStateException("Select an item first");
    }

    @Override
    public void refund(VendingMachine machine) {
        machine.refundBalance();
        machine.setState(new IdleState());
    }
}
