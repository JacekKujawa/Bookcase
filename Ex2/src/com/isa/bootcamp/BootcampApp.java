package com.isa.bootcamp;

public class BootcampApp {
    public static void main(String[] args) {
        Task ex1 = new Task();
        Task ex2 = new Task();
        Student student1 = new Student();
        Student student2 = new Student();
        Score scoreS1 = new Score(student1, ex1, 15, "Lubi grzyby");
        Score scoreS2 = new Score(student2, ex2, 25, "Lubi grzyby też");


        ex1.setTaskCommand("Ile jest Buraków na polu 3ha x 4ha");
        ex1.setTaskNumber("Ex1");
        ex2.setTaskCommand("Ile jest Kukurydzy na polu 3ha x 4ha");
        ex2.setTaskNumber("Ex2");

        student1.setFirstName("Roman");
        student1.setLastName("Burak");
        student2.setFirstName("Felix");
        student2.setLastName("Drzazga");

        System.out.println(scoreS1.getStudent().getFirstName()+" "+scoreS1.getStudent().getLastName()+
                " za zadanie "+scoreS1.getTask().getTaskNumber()+" otrzymał "+scoreS1.getScoreNumber()+" punktów. ");
        System.out.println(scoreS2.getStudent().getFirstName()+" "+scoreS2.getStudent().getLastName()+
                " za zadanie "+scoreS2.getTask().getTaskNumber()+" otrzymał "+scoreS2.getScoreNumber()+" punktów. ");










    }
}
