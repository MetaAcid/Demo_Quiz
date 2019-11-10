package ru.erixon.quizdemo.model.question;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Question {
    private BufferedImage image;
    private String answer;

    public Question(BufferedImage image, String answer) {
        this.image = image;
        this.answer = answer;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }
}
