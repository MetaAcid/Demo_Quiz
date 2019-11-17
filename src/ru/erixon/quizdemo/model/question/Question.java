package ru.erixon.quizdemo.model.question;

import java.awt.image.BufferedImage;

public class Question {
    private long id;
    private BufferedImage image;
    private String answer;
    private Difficulty difficulty;


    public Question(long id, BufferedImage image, String answer, Difficulty difficulty) {
        this.id = id;
        this.image = image;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public long getId() {
        return id;
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
