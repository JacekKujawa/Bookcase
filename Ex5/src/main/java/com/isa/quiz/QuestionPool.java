package com.isa.quiz;

import java.util.Random;

public class QuestionPool {

    public static int[] questionNumberGenerate() {
        Random random = new Random();
        int[] questionNumb = new int[4];
        questionNumb[0]=random.nextInt(5)+1;;

        for (int i = 1; i < questionNumb.length; i++) {

            questionNumb[i]=random.nextInt(5)+1;
            if(questionNumb[i-1]==questionNumb[i])
            {
                i--;
            }

        }
        return questionNumb;
    }

}
