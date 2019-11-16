package ru.erixon.quizdemo.model.question;

import java.awt.image.BufferedImage;

public class Question {
    private BufferedImage image;
    private String answer;
    private Difficulty difficulty;

    public Question(BufferedImage image, String answer, Difficulty difficulty) {
        this.image = image;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public enum Difficulty {
        EASY, NORMAL, HARD
    }
}
