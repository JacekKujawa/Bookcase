package com.isa.quiz;

import java.util.List;

public class Answer {

    private final List<String> answers = List.of("c","b","a","d","b");
    private final List<String> answersToUpperCase = List.of("C","B","A","D","B");

    public List<String> getAnswers() {
        return answers;
    }

    public List<String> getAnswersToUpperCase() {
        return answersToUpperCase;
    }
}
