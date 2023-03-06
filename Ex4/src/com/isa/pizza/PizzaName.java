package com.isa.pizza;

public enum PizzaName {
    CAPRICCIOSA,
    MARGARITA,
    NAPOLETANA,
    DIAVIOLA;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
