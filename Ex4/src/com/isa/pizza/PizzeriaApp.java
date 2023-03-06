package com.isa.pizza;

public class PizzeriaApp {
    public static void main(String[] args) {
        Order order1 = new Order();
        System.out.println(order1 + "\n");
        System.out.println("Print hashCode: ");
        System.out.println(order1.getClient1().hashCode());
        System.out.println(order1.getClient2().hashCode());
        System.out.println(order1.getClient3().hashCode());
        System.out.println("Print equals method: ");
        System.out.println(order1.getClient1().equals(order1.getClient2()));
    }
}
