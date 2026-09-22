package org.example.vendingmachine.model;

public class ItemShelf {
    private final String code;
    private final Item item;
    private int quantity;

    public ItemShelf(String code, Item item, int quantity) {
        this.code = code;
        this.item = item;
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public Item getItem() {
        return item;
    }

    public synchronized void addStock(int quantity) {
        this.quantity += quantity;
    }

    public synchronized boolean tryDispense() {
        if(this.quantity <= 0) return false;
        quantity--;
        return true;
    }
}
