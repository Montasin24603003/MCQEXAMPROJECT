package com.quiz.model;

public class Question {
    private final String question;
    private final String[] options;
    private final int correctIndex;
    private final String category;

    public Question(String question, String[] options, int correctIndex, String category) {
        if (options.length != 4) {
            throw new IllegalArgumentException("Questions must have exactly 4 options");
        }
        if (correctIndex < 0 || correctIndex >= options.length) {
            throw new IllegalArgumentException("Correct index out of bounds");
        }
        
        this.question = question;
        this.options = options.clone();
        this.correctIndex = correctIndex;
        this.category = category;
    }

    public String getQuestion() { return question; }
    public String[] getOptions() { return options.clone(); }
    public int getCorrectIndex() { return correctIndex; }
    public String getCategory() { return category; }
}