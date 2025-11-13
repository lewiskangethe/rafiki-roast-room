package com.rafikiroast.models;

public class Proteins {
    private String name;
    private double extraCost;

    public Proteins(String name, double extraCost) {
        this.name = name;
        this.extraCost = extraCost;
    }

    public String getName() {
        return name;
    }

    public double getExtraCost() {
        return extraCost;
    }

    @Override
    public String toString() {
        return name + " (Extra: $" + String.format("%.2f", extraCost) + ")";
    }
}
