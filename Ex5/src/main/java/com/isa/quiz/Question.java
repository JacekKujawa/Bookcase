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
            System.out.println("Bravo! the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(0));
        }

    }

    public static void question2(int num) {
        Answer a = new Answer();
        System.out.println("Question " + num + "  of 3:\n" +
                "How do you insert COMMENTS in Java code?\n" +
                "A. # This is a comment.\n" +
                "B. // This is a comment.\n" +
                "C. /* This is a comment\n" +
                "D. All of the above.");
        System.out.println("Select answer(A,B,C,D): ");
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(1)) || answer.equals(a.getAnswersToUpperCase().get(1))) {
            System.out.println("Bravo! the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(1));
        }

    }

    public static void question3(int num) {
        Answer a = new Answer();
        System.out.println("Question " + num + "  of 3:\n" +
                "Which data type is used to create a variable that should store text?\n" +
                "A. String\n" +
                "B. myString\n" +
                "C. strings\n" +
                "D. Txt");
        System.out.println("Select answer(A,B,C,D): ");
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(2)) || answer.equals(a.getAnswersToUpperCase().get(2))) {
            System.out.println("Bravo! the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(2));
        }

    }

    public static void question4(int num) {
        Answer a = new Answer();
        System.out.println("Question " + num + "  of 3:\n" +
                "How do you create a variable with the numeric value 5?\n" +
                "A. num x = 5\n" +
                "B. x = 5;\n" +
                "C. float x = 5;\n" +
                "D. int x = 5;");
        System.out.println("Select answer(A,B,C,D): ");
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(3)) || answer.equals(a.getAnswersToUpperCase().get(3))) {
            System.out.println("Bravo! the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(3));
        }

    }

    public static void question5(int num) {
        Answer a = new Answer();
        System.out.println("Question " + num + "  of 3:\n" +
                "How do you create a variable with the floating number 2.8?\n" +
                "A. byte x = 2.8f\n" +
                "B. float x = 2.8f;\n" +
                "C. int x = 2.8f;\n" +
                "D. x = 2.8f;");
        System.out.println("Select answer(A,B,C,D): ");
        String answer = scanner.nextLine();
        if (answer.equals(a.getAnswers().get(4)) || answer.equals(a.getAnswersToUpperCase().get(4))) {
            System.out.println("Bravo! the answer is good");
            points++;
        } else {
            System.out.println("Sorry but it is not good answer, the correct is:  " + a.getAnswersToUpperCase().get(4));
        }

    }
}





