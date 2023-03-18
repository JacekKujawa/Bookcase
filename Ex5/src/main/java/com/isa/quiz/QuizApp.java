package com.isa.quiz;


import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class QuizApp {
    public static void main(String[] args) {
//        System.out.println("Welcome to Quiz.");
//
//        // call the quiz method
//        QuestionPool.question1();


        QuestionPool.question1(1);

        System.out.println( "Your quiz score:"+ QuestionPool.getPoints() );

    }
}
