package com.isa.quiz;

import java.util.Scanner;

public class Question {
    private static Integer points = 0;

    static Scanner scanner = new Scanner(System.in);

    public static Integer getPoints() {
        return points;
    }

    public static void question1(int num) {
        Answer a = new Answer();
        System.out.println("Question " + num + "  of 3:\n" +
                "What is a correct syntax to output \"Hello World\" in Java?\n" +
                "A. echo(\"Hello World\")\n" +
                "B. Console.WriteLine(\"Hello World\")\n" +
                "C. System.out.println(\"Hello World\")\n" +
                "D. print(\"Hello World\")");
        System.out.println("Select answer(A,B,C,D): ");
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(0)) || answer.equals(a.getAnswersToUpperCase().get(0))) {
            System.out.println("Bravo the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(0));
        }

    }
    }





