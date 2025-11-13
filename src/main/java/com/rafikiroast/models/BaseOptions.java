package com.rafikiroast.models;

public class BaseOptions {
    private String name;
    private String size;
    private double basePrice;

    public BaseOptions(String name, String size, double basePrice) {
        this.name = name;
        this.size = size;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return size + " " + name + " - $" + String.format("%.2f", basePrice);
    }
}
