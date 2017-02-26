package com.codeclan.example.shopkeep;

/**
 * Created by user on 24/02/2017.
 */
public class Item {

    private double itemCost;
    private String itemName;

    public Item(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public double getItemCost() {
        return itemCost;
    }

    public String getItemName() {
        return itemName;
    }
}

