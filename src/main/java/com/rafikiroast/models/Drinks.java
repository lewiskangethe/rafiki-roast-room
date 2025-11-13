package com.rafikiroast.models;

public class Drinks {
    private String name;
    private String size;
    private double price;

    public Drinks(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return size + " " + name + " - $" + String.format("%.2f", price);
    }
}
