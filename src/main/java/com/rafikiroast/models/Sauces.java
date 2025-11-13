package com.rafikiroast.models;

public class Sauces {
    private String name;

    public Sauces(String name) {
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
