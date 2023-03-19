package com.isa.quiz;

import java.util.List;
import java.util.Scanner;

public class Answer {

    private final List<String> answers = List.of("c", "b", "a", "d", "b");
    private final List<String> answersToUpperCase = List.of("C", "B", "A", "D", "B");
    private static int points = 0;

    public static void checkAnswer(int questionNumber) {
        Answer a = new Answer();
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(questionNumber)) || answer.equals(a.getAnswersToUpperCase().get(questionNumber))) {
            System.out.println("Bravo! The answer is correct :) ");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct answer is: " + a.getAnswersToUpperCase().get(questionNumber));
        }
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<String> getAnswersToUpperCase() {
        return answersToUpperCase;
    }

    public static int getPoints() {
        return points;
    }
}
