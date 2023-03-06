package com.isa.pizza;

public class PizzeriaApp {
    public static void main(String[] args) {
        System.out.println("Hallo world");

        Pizza pizza = new Pizza(PizzaName.CAPRICCIOSA, PizzaSize.FAMILY, 1);
        System.out.println(pizza.getPizzaName() );
        System.out.println(pizza.getQuantity() );
    }
}
