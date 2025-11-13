package com.rafikiroast.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int orderNumber;
    private List<OrderItem> items = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();

    public Order() {
        orderNumber = counter;
        counter += 1;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items)
            total += item.getTotalPrice();
        for (Drinks drink : drinks)
            total += drink.getPrice();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append("\n");
        sb.append("Items:\n");
        for (OrderItem item : items) sb.append(item).append("\n");

        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drinks d : drinks) sb.append(d).append("\n");
        }

        sb.append("Total Order Cost: $").append(String.format("%.2f", getTotal())).append("\n");
        return sb.toString();
    }
}
