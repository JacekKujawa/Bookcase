package com.isa.quiz;

import javax.swing.*;
import java.util.Scanner;

public class Question {
    private static Integer points=0;
    private static String answer;
    static Scanner scanner = new Scanner(System.in);
    public static void question1() {
        System.out.println("Question 1 of 5:\n" +
                "What is a correct syntax to output \"Hello World\" in Java?\n" +
                "A. echo(\"Hello World\")\n" +
                "B. Console.WriteLine(\"Hello World\")\n" +
                "C. System.out.println(\"Hello World\")\n" +
                "D. print(\"Hello World\")");
        System.out.println("Select answer: ");
        answer = scanner.nextLine();
        switch (answer){
            case "C", "c" -> points++;
        }
    }



}
