package ru.erixon.quizdemo.utils;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.QuestionDao;
import ru.erixon.quizdemo.model.question.Question;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageLoader {
    public static void main(String[] args) throws Exception {
        QuestionDao questionDao = new QuestionDao(Application.manager.getConnection());
        File dir  = new File("C:\\Users\\Никита\\Desktop\\Questions Images\\Новая папка");
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toUpperCase().matches("(EASY|NORMAL|HARD)_[0-9]+\\.PNG");
            }
        });

        File[] answers = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toUpperCase().matches("(EASY|NORMAL|HARD)_[0-9]+\\.TXT");
            }
        });

        if (files.length != answers.length) {
            throw new Exception("wrong number of questions");
        }

        for (int i = 0; i < files.length; ++i) {
            File imageFile = files[i];
            File answer = answers[i];
            BufferedImage image = ImageIO.read(imageFile);
            String answerText = null;
            try (FileReader fileReader = new FileReader(answer); BufferedReader reader = new BufferedReader(fileReader)) {
                answerText = reader.readLine();
            }
            Question question = new Question(image,answerText, getDifficulty(imageFile));
            questionDao.insert(question);
        }

        System.out.println("!");
    }

    public static Question.Difficulty getDifficulty(File file) {
        String name = file.getName();
        if (name.toUpperCase().startsWith("EASY")){
            return Question.Difficulty.EASY;
        }
        else if (name.toUpperCase().startsWith("NORMAL")){
            return Question.Difficulty.NORMAL;
        }
        else if (name.toUpperCase().startsWith("HARD")) {
            return Question.Difficulty.HARD;
        }
        throw  new RuntimeException();

    }
}
