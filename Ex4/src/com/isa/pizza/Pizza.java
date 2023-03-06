package com.isa.pizza;

import java.util.Objects;

public class Pizza extends Product {
private Enum pizzaName;
private Enum pizzaSize;
    public Pizza(Enum pizzaName, Enum pizzaSize, Integer quantity) {
        super(quantity);
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName = " + pizzaName.toString() +
                ", pizzaSize = " + pizzaSize.toString() +
                ", quantity = " + getQuantity()+
                '}';
    }

    public Enum getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(Enum pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Enum getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(Enum pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(pizzaName, pizza.pizzaName) && Objects.equals(pizzaSize, pizza.pizzaSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaName, pizzaSize);
    }
}
