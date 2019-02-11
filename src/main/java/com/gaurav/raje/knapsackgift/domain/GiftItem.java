package com.gaurav.raje.knapsackgift.domain;

import java.math.BigDecimal;

public class GiftItem {

    public static final GiftItem NO_ITEM_FOUND;
    static {
        NO_ITEM_FOUND = new GiftItem();
        NO_ITEM_FOUND.setCost(Integer.MAX_VALUE);
        NO_ITEM_FOUND.setName("No Item Found");
    }
    protected int cost;
    protected String name;

    public GiftItem() {
    }

    public GiftItem(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    // This is never used. But introducing for descriptive purposes
    final int quantity = Integer.MAX_VALUE;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "GiftItem{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
