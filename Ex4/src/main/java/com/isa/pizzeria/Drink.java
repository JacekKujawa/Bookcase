package com.isa.pizzeria;

public class Drink extends Product {
    private Enum drinkName;

    public Drink(Enum drinkName, Integer quantity) {
        super(quantity);
        this.drinkName = drinkName;
    }

    @Override
    public String toString() {
        return "Drink{" + "drinkName=" + drinkName + ", quantity = " + getQuantity() + '}';
    }
}
