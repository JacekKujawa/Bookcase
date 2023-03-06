package com.isa.pizzeria;

public class Order {
    Client client1 = new Client("Zenek", "Łąkowa 11E", "555-555-555");
    Client client2 = new Client("Krysia", "Nadrzeczna 6/3", "999-999-999");
    Client client3 = new Client("Antoni", "Polna 13", "777-777-777");
    Product pizza1 = new Pizza(PizzaName.PEPPERONI, PizzaSize.FAMILY, 1);
    Product drink1 = new Drink(DrinkName.JUICE, 2);
    Product pizza2 = new Pizza(PizzaName.DIAVIOLA, PizzaSize.SMALL, 1);
    Product pizza2a = new Pizza(PizzaName.CAPRICCIOSA, PizzaSize.MIDDLE, 1);
    Product drink2 = new Drink(DrinkName.COLA, 1);
    Product hamburger3 = new Hamburger(1);
    Product drink3 = new Drink(DrinkName.BEER, 1);


    @Override
    public String toString() {
        return
                "\n\n" + "Client1=" + client1 +
                        ", pizza1=" + pizza1 +
                        ", drink1=" + drink1 + "\n\n" +
                        "Client2=" + client2 +
                        ", pizza2=" + pizza2 +
                        ", pizza2a=" + pizza2a +
                        ", drink2=" + drink2 + "\n\n" +
                        "Client3=" + client3 +
                        ", hamburger3=" + hamburger3 +
                        ", drink3=" + drink3;
    }

    public Client getClient1() {
        return client1;
    }

    public Client getClient2() {
        return client2;
    }

    public Client getClient3() {
        return client3;
    }

}

