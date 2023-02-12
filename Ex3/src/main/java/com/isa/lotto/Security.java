package com.isa.lotto;

import java.sql.Struct;

public class Security {
    private boolean s;

    public void security(int x, int y) {
        if (y > 0 && x >= y) {      // is the number positive?
            System.out.println("Podane wartości " + x + " i " + y + " są prawidłowe :)");
            s = false;
        } else { //if the number is not positive?
            System.out.println("Błąd!!! Podane wartości " + x + " i " + y + " muszą być liczbami dodatnimi oraz zakres większy od ilości liczb:)");
            System.out.println("Podaj liczby jeszcze raz:)");
            s = true;
        }
    }

    public boolean isS() {
        return s;
    }
}
