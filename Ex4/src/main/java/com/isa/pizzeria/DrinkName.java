package com.isa.pizzeria;

public enum DrinkName {
    COLA,
    BEER,
    JUICE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
