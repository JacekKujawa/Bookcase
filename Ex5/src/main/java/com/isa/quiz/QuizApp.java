package com.isa.quiz;

public class QuizApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Quiz.");

        QuestionPool.printQuestion();

        System.out.println("Your quiz score: " + Answer.getPoints());
    }
}
