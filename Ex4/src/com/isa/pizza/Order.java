package com.isa.pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {

    Client client1 = new Client("Zenek", "Łąkowa 11E", "555-555-555");
    Client client2 = new Client("Krysia", "Nadrzecznej 6/3", "999-999-999");
    Client client3 = new Client("Antoni", "Polna 13", "777-777-777");

    Pizza pizza1 = new Pizza(PizzaName.PEPPERONI, PizzaSize.FAMILY, 1);
    Drink drink1 = new Drink(DrinkName.JUICE, 2);
    Pizza pizza2 = new Pizza(PizzaName.DIAVIOLA, PizzaSize.SMALL, 1);
    Pizza pizza2a = new Pizza(PizzaName.CAPRICCIOSA, PizzaSize.MIDDLE, 1);
    Drink drink2 = new Drink(DrinkName.COLA, 1);
    Hamburger hamburger3 = new Hamburger(1);

    Drink drink3 = new Drink(DrinkName.BEER, 1);



}
