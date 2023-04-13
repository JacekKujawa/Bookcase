package com.isa.pizzeria;

public enum PizzaSize {
    SMALL,
    MIDDLE,
    FAMILY;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
