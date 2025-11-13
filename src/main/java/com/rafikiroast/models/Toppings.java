package com.rafikiroast.models;

public class Toppings {
    private String name;

    public Toppings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
