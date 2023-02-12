package com.isa.lotto;

public class LottoApp {
    public static void main(String[] args) {
        ReadNumber n1 = new ReadNumber();
        Draw d1 = new Draw();
        n1.data();
        //make array
        d1.arrayMake(n1.getQuantity());
        //generate numbers1
        d1.generate(n1.getRange());
        System.out.println("wylosowane liczby to:");
        // write numbers in console
        d1.write();
    }
}
