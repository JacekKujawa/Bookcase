package com.isa.quiz;

import java.util.List;

public class Answer {

    private final List<String> answers = List.of("c","a","b","d","a");
    private final List<String> answersToUpperCase = List.of("C","A","B","D","A");

    public List<String> getAnswers() {
        return answers;
    }

    public List<String> getAnswersToUpperCase() {
        return answersToUpperCase;
    }
}
