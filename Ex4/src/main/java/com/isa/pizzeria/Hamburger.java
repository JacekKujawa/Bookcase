package com.isa.pizzeria;

public class Hamburger extends Product {

    public Hamburger(Integer quantity) {
        super(quantity);

    }

    @Override
    public String toString() {
        return "Hamburger" +
                ", quantity = " + getQuantity() +
                '}';
    }
}
