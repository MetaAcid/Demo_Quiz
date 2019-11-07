package ru.artimenko.quizdemo;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("Quiz");
//        TeacherFrame Frametest = new TeacherFrame("Main Window");
//        MainWindow(Frametest);
//        StudentDialog(Frametest);
//        TeacherDialog(Frametest);

    }

    public static void StudentDialog(TeacherFrame Frametest){
        BaseDialog studentDialog = new BaseDialog(Frametest, "test") {};
        Panel pnlLogIn = new Panel();
        TextArea txtAcountName = new TextArea();
        TextArea txtPassword = new TextArea();
        Button btnLogIn = new Button();

        pnlLogIn.add(txtAcountName);
        pnlLogIn.add(txtPassword);

        studentDialog.setVisible(true);
        studentDialog.setSize(500, 600);
        studentDialog.setLocation(800, 800);
        studentDialog.add(pnlLogIn, BorderLayout.CENTER);
        studentDialog.add(btnLogIn, BorderLayout.SOUTH);
    }
    public static void TeacherDialog(TeacherFrame FrameTest){
        BaseDialog teacherDialog = new BaseDialog(FrameTest,"test") {};
        Panel pnlLogIn = new Panel();
        Button btnLogIn = new Button();
        TextArea txtAccountName = new TextArea();
        TextArea txtPassword = new TextArea();
        TextArea txtClassID = new TextArea();

        pnlLogIn.add(txtAccountName);
        pnlLogIn.add(txtClassID);
        pnlLogIn.add(txtPassword);

        teacherDialog.setVisible(true);
        teacherDialog.setSize(500,600);
        teacherDialog.setLocation(800, 800);
        teacherDialog.add(pnlLogIn, BorderLayout.CENTER);
        teacherDialog.add(btnLogIn, BorderLayout.SOUTH);
    }
}
