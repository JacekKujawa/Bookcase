package com.isa.pizzeria;

public enum PizzaName {
    CAPRICCIOSA,
    MARGARITA,
    NAPOLETANA,

    PEPPERONI,
    DIAVIOLA;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
