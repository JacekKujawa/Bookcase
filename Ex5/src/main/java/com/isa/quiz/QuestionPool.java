package com.isa.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionPool {
    private static Integer points = 0;
    private static String answer;



    static Scanner scanner = new Scanner(System.in);


    public static Integer getPoints() {
        return points;
    }

    public static void question1() {
        System.out.println("Question 1 of 3:\n" +
                "What is a correct syntax to output \"Hello World\" in Java?\n" +
                "A. echo(\"Hello World\")\n" +
                "B. Console.WriteLine(\"Hello World\")\n" +
                "C. System.out.println(\"Hello World\")\n" +
                "D. print(\"Hello World\")");
        System.out.println("Select answer: ");
        answer = scanner.nextLine();
        switch (answer) {
            case "C", "c" -> points++;
        }
    }

    public static void question2() {
        System.out.println("Question 2 of 3:\n" +
                "What is a correct syntax to output \"Hello World\" in Java?\n" +
                "A. echo(\"Hello World\")\n" +
                "B. Console.WriteLine(\"Hello World\")\n" +
                "C. System.out.println(\"Hello World\")\n" +
                "D. print(\"Hello World\")");
        System.out.println("Select answer: ");
        answer = scanner.nextLine();
        switch (answer) {
            case "C", "c" -> points++;
        }
    }


}


