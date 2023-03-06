package com.isa.pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {


    List<Product> productList = new ArrayList<>();
    Pizza pizza1 = new Pizza(PizzaName.CAPRICCIOSA, PizzaSize.FAMILY, 1);
    Drink drink1 = new Drink(DrinkName.COLA, 1);
    Client client = new Client();

    public List<Product> getAll() {
        return productList;
    }

    public void addProduct(Pizza pizza, Drink drink, Hamburger hamburger) {
        productList.add(pizza);
        productList.add(drink);
        productList.add(hamburger);

    }




    public void makeOrder(Client client, List<Product> productListList) {
        this.client = client;
        this.productList = productListList;

    }

}
