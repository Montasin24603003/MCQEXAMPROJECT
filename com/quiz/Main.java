package com.quiz;

import com.quiz.model.Question;
import com.quiz.ui.QuizFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting quiz application...");  
        Question[] questions = new Question[] {
            new Question("What is the capital of France?", 
                new String[]{"Berlin", "Paris", "Rome", "Madrid"}, 1, "Geography"),
            new Question("2 + 2 = ?", 
                new String[]{"3", "4", "5", "6"}, 1, "Math"),
            new Question("Which language runs in a browser?", 
                new String[]{"Java", "C", "Python", "JavaScript"}, 3, "Technology"),
            new Question("What is OOP?", 
                new String[]{"Programming", "Design", "Concept", "All of these"}, 3, "Programming"),
            new Question("Which planet is known as the Red Planet?", 
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1, "Science"),
            new Question("Who painted the Mona Lisa?", 
                new String[]{"Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"}, 2, "Art"),
            new Question("What is the largest ocean on Earth?", 
                new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3, "Geography"),
            new Question("Which country gifted the Statue of Liberty to the US?", 
                new String[]{"England", "France", "Spain", "Italy"}, 1, "History"),
            new Question("What is the chemical symbol for gold?", 
                new String[]{"Go", "Gd", "Au", "Ag"}, 2, "Science"),
            new Question("In which year did World War II end?", 
                new String[]{"1943", "1945", "1947", "1950"}, 1, "History")
        };

        try {
            SwingUtilities.invokeLater(() -> {
                System.out.println("Creating QuizFrame..."); 
                QuizFrame frame = new QuizFrame(questions);
                frame.setVisible(true); 
                System.out.println("QuizFrame should be visible now"); 
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}