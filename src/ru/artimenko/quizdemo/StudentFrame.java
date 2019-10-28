package ru.artimenko.quizdemo;

import java.awt.*;

public class StudentFrame {
    public static void main(String[] args) {
        chooseDifficultyFrame();
        chooseFrame();
    }
    public static void chooseFrame(){
        TeacherFrame  FrameStudentTest = new TeacherFrame("Student");
        Button btnPlayQuiz = new Button("Play A Quiz!");
        Button btnStat = new Button("Your Statistics");
        Panel pnlButtons = new Panel();

        pnlButtons.add(btnPlayQuiz);
        pnlButtons.add(btnStat);

        FrameStudentTest.setVisible(true);
        FrameStudentTest.setSize(600, 800);
        FrameStudentTest.setLocation(800,800);
        FrameStudentTest.add(pnlButtons, BorderLayout.CENTER);
    }
    public static void chooseDifficultyFrame(){
        TeacherFrame FrameStudentTest = new TeacherFrame("Difficulty");
        Label lblSign = new Label();
        Button btnNext = new Button();
        Checkbox chkEasy = new Checkbox();
        Checkbox chkNormal = new Checkbox();
        Checkbox chkHard = new Checkbox();
        Panel pnlDifficulty = new Panel();

        pnlDifficulty.add(chkEasy, BorderLayout.SOUTH);
        pnlDifficulty.add(chkNormal, BorderLayout.CENTER);
        pnlDifficulty.add(chkHard, BorderLayout.NORTH);

        FrameStudentTest.setVisible(true);
        FrameStudentTest.setSize(600, 800);
        FrameStudentTest.setLocation(800,800);
        FrameStudentTest.add(lblSign, BorderLayout.NORTH);
        FrameStudentTest.add(pnlDifficulty, BorderLayout.CENTER);
        FrameStudentTest.add(btnNext, BorderLayout.SOUTH);
    }
}
