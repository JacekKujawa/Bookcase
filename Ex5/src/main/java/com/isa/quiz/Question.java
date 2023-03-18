package com.isa.quiz;

import java.util.Random;

public class Question {

    public static int[] questionNumberGenerate() {

        int[] questionNumb = new int[4];
        questionNumb[0]=numberGenerate();

        for (int i = 1; i < questionNumb.length; i++) {

            questionNumb[i]=numberGenerate();
            if(questionNumb[i-1]==questionNumb[i])
            {
                i--;
            }

        }
        return questionNumb;
    }

    public static int numberGenerate() {
        Random random = new Random();
        return random.nextInt(5)+1;
    }

}
