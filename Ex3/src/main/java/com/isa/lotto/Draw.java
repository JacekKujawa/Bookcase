package com.isa.lotto;

import java.util.Random;

public class Draw {
    int k = 0;
    private int[] array;
    private int[] resultArray;

    public void arrayMake(int n) {
        this.array = new int[n];
        this.resultArray = new int[n];
    }
    //generate numbers in array
    public void generate(int n) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(n) + 1;
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    exists = true;
                    --i;
                }
            }
            if (!exists) {
                resultArray[k] = array[i];
                k++;
            }
        }
    }
    //write numbers void
    public void write() {
        for (int i = 0; i < k; i++) {
            System.out.println(resultArray[i] + " ");
        }
    }
}