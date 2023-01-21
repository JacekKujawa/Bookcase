package com.isa.bootcamp;

public class Score {

    private int scoreNumber;
    private String feedback;

    public Score(int scoreNumber, String feedback) {
        this.scoreNumber = scoreNumber;
        this.feedback = feedback;
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
