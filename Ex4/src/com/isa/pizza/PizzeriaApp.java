package com.isa.pizza;

import java.util.List;

public class PizzeriaApp {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(PizzaName.NAPOLETANA, PizzaSize.FAMILY, 1);
        Drink drink1 = new Drink(DrinkName.COLA, 1);
        Hamburger hamburger = new Hamburger(1);
        Client client1 = new Client();
        Order order1 = new Order();
        System.out.println(pizza1.toString());


    }
}
