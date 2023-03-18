package com.isa.quiz;




/**
 * Hello world!
 *
 */
public class QuizApp
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to Quiz.");

        // call the quiz method
        QuestionPool.question1();



        System.out.println( "Your quiz score:"+ QuestionPool.getPoints() );
    }
}
