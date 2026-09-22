package org.example.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private  final Map<String, ItemShelf> map = new HashMap<>();

    public boolean addShelf(String code, Item item, int qty) {
        if(map.containsKey(code)) return false;
        map.put(code, new ItemShelf(code, item, qty));
        return true;
    }

    public ItemShelf getShelf(String code) {
        return map.get(code);
    }
}
