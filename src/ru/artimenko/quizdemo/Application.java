package ru.artimenko.quizdemo;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        TeacherFrame Frametest = new TeacherFrame("Main Window");
        MainWindow(Frametest);
        StudentDialog(Frametest);

    }
    public static void MainWindow(TeacherFrame Frametest){
        Button btnRegister = new Button("Register");
        Button btnTeacher = new Button("Teacher");
        Button btnStudent = new Button("Student");
        Label lblWelcome = new Label("Welcome to a Math Quiz!");
        Panel btnMainPanel = new Panel();

        Frametest.setVisible(true);
        Frametest.setSize(500, 600);

        btnMainPanel.setLayout(new GridLayout(1,3));
        btnMainPanel.add(btnRegister);
        btnMainPanel.add(btnStudent);
        btnMainPanel.add(btnTeacher);

        Frametest.add(btnMainPanel, BorderLayout.NORTH);
        Frametest.add(lblWelcome, BorderLayout.CENTER);
    }
    public static void StudentDialog(TeacherFrame Frametest){
        BaseDialog studentDialog = new BaseDialog(Frametest) {};

        studentDialog.setVisible(true);
        studentDialog.setSize(500, 600);
        studentDialog.setLocation(800, 800);
    }
}
