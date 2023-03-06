package com.isa.pizza;

public class Drink extends Product {
    private Enum drinkName;

    public Drink(Enum drinkName, Integer quantity) {
        super(quantity);
        this.drinkName=drinkName;
    }
}
