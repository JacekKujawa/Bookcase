package com.isa.pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {


    List<Product> productList = new ArrayList<>();


    public List<Product> getAll() {
        return productList;
    }

    public List<Product> addProduct(Pizza pizza, Drink drink, Hamburger hamburger) {
        productList.add(pizza);
        productList.add(drink);
        productList.add(hamburger);

        return getAll();

    }


}
