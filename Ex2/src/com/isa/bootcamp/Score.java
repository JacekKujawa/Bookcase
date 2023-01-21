package com.isa.bootcamp;

public class Score {
    private Student student;
    private Task task;
    private int scoreNumber;
    private String feedback;

    public Score(Student student, Task task, int scoreNumber, String feedback) {
        this.student = student;
        this.task = task;
        this.scoreNumber = scoreNumber;
        this.feedback = feedback;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(int scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


}
