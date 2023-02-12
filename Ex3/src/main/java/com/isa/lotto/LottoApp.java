package com.isa.lotto;

public class LottoApp {
    public static void main(String[] args) {
        // make objects n1,d1,n1
        ReadNumber n1 = new ReadNumber();
        Draw d1 = new Draw();
        n1.data();
        //make array
        d1.arrayMake(n1.getQuantity());
        // generate numbers
        d1.generate(n1.getRange());
        System.out.println("wylosowane liczby to:");
        // write numbers in console
        d1.write();
    }
}
