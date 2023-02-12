package com.isa.lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadNumber {
    private int range;
    private int quantity;

    public void data() {
        Security s1 = new Security();
        do {
            // exception start
            try {
                // Make new object d1,s1,scanner
                Scanner scanner = new Scanner(System.in);
                // Read range and quantity
                System.out.println("Podaj z jakiego zakresu mam wylosować liczby: ");
                range = scanner.nextInt();
                System.out.println("Podaj ile liczb mam wylosować:");
                quantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Błąd formatu danych!!! Podaj liczby (" + e + ")");
            }
            //numbers check
            s1.security(range, quantity);

        } while (s1.isS());
        System.out.println("Uwaga..uwaga..rozpoczynam..losowanie.."+quantity+"..liczb..z.."+range+"..");
    }

    public int getRange() {
        return range;
    }

    public int getQuantity() {
        return quantity;
    }
}