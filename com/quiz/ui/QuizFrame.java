package com.quiz.ui;

import com.quiz.model.Question;
import com.quiz.manager.ScoreManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class QuizFrame extends JFrame {
    private final Question[] questions;
    private int current = 0;
    private int score = 0;
    private final List<String> wrongAnswers = new ArrayList<>();
    private Instant startTime;
 
    private final JLabel questionLabel = new JLabel("Question", SwingConstants.LEFT);
    private final JLabel timerLabel = new JLabel("00:00", SwingConstants.RIGHT);
    private final JRadioButton[] options = new JRadioButton[4];
    private final ButtonGroup group = new ButtonGroup();
    private final JButton nextButton = new JButton("Next");
    private final JLabel progressLabel = new JLabel("", SwingConstants.RIGHT);

    public QuizFrame(Question[] questions) {
        this.questions = questions;
         
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
        }
        
        initializeUI();
        startTime = Instant.now();
        loadQuestion(current);
    }

    private void initializeUI() {
        setTitle("Quiz Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
 
        JPanel headerPanel = new JPanel(new BorderLayout());
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        rightPanel.add(progressLabel);
        rightPanel.add(timerLabel);
        headerPanel.add(questionLabel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);
 
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 5, 5));
        for (JRadioButton option : options) {
            option.setFont(new Font("Arial", Font.PLAIN, 14));
            optionsPanel.add(option);
        }
        add(optionsPanel, BorderLayout.CENTER);
 
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(this::handleNextButton);
        add(nextButton, BorderLayout.SOUTH);
 
        new Timer(1000, e -> updateTimer()).start();
    }

    private void handleNextButton(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) selected = i;
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer!", 
                "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Question currentQuestion = questions[current];
        if (selected != currentQuestion.getCorrectIndex()) {
            String correctAnswer = currentQuestion.getOptions()[currentQuestion.getCorrectIndex()];
            wrongAnswers.add("Q" + (current + 1) + " (Correct: " + correctAnswer + ")");
        } else {
            score++;
        }

        current++;
        if (current < questions.length) {
            loadQuestion(current);
        } else {
            finishQuiz();
        }
    }

    private void loadQuestion(int index) {
        group.clearSelection();
        Question q = questions[index];
        questionLabel.setText("Q" + (index + 1) + ": " + q.getQuestion());
        progressLabel.setText("Question " + (index + 1) + " of " + questions.length);
        
        String[] opts = q.getOptions();
        for (int i = 0; i < opts.length; i++) {
            options[i].setText(opts[i]);
        }
    }

    private void updateTimer() {
        long seconds = Instant.now().getEpochSecond() - startTime.getEpochSecond();
        long minutes = seconds / 60;
        seconds = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    private void finishQuiz() {
        long timeTaken = Instant.now().getEpochSecond() - startTime.getEpochSecond();
        
        String name = "";
        while (name.trim().isEmpty()) {
            name = JOptionPane.showInputDialog(this, 
                "Quiz Finished!\nYour score: " + score + "/" + questions.length + 
                "\nTime taken: " + timeTaken + " seconds\n\nEnter your name:");
            if (name == null) name = "Anonymous";
        }

        String wrongAnswersStr = String.join(", ", wrongAnswers);
        ScoreManager.saveScore(name, score, questions.length, timeTaken, wrongAnswersStr);
        
        JOptionPane.showMessageDialog(this, 
            "Thank you for taking the quiz!\n" +
            "Final Score: " + score + "/" + questions.length + "\n" +
            "Time Taken: " + timeTaken + " seconds\n" +
            (wrongAnswers.isEmpty() ? "Perfect! No wrong answers." : 
             "Wrong answers: " + wrongAnswersStr));
        
        System.exit(0);
    }
}