package com.quiz.manager;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScoreManager {
    private static final String FILE_NAME = "scores.txt";
    private static final DateTimeFormatter TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void saveScore(String name, int score, int totalQuestions, 
                               long timeTaken, String wrongAnswers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            String record = String.format("%s | %s | Score: %d/%d | Time: %d sec | Wrong: %s%n",
                    timestamp, name, score, totalQuestions, timeTaken, 
                    wrongAnswers.isEmpty() ? "None" : wrongAnswers);
            bw.write(record);
        } catch (IOException e) {
            System.err.println("Error saving score: " + e.getMessage());
        }
    }
}