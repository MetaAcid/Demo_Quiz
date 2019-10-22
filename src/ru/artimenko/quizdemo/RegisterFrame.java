package ru.artimenko.quizdemo;

import java.awt.*;

public class RegisterFrame  {
    public static void main(String[] args) {
        TeacherFrame registerTest = new TeacherFrame("Register");
        RegisterTest(registerTest);
        RegisterTeacher(registerTest);

    }
    public static void RegisterTest(TeacherFrame registerTest){

        Panel pnlRegister = new Panel();
        Panel pnlInputStudent = new Panel();
        TextArea txtName = new TextArea();
        TextArea txtSurname = new TextArea();
        TextArea txtPassword = new TextArea();
        TextArea txtClassID = new TextArea();
        Button btnStudent = new Button("Student");
        Button btnTeacher = new Button("Teacher");
        Button btnRegister = new Button("Register");

        pnlRegister.add(btnStudent);
        pnlRegister.add(btnTeacher);
        pnlInputStudent.add(txtName);
        pnlInputStudent.add(txtSurname);
        pnlInputStudent.add(txtPassword);
        pnlInputStudent.add(txtClassID);

        registerTest.setVisible(true);
        registerTest.setSize(400,500);
        registerTest.setLocation(600, 660);

        registerTest.add(pnlRegister, BorderLayout.NORTH);
        registerTest.add(pnlInputStudent, BorderLayout.CENTER);
        registerTest.add(btnRegister, BorderLayout.SOUTH);
    }
    public static void registerTeacher(TeacherFrame registerTest) {

        Panel pnlRegister = new Panel();
        Panel pnlInputTeacher = new Panel();
        Button btnStudent = new Button("Student");
        Button btnTeacher = new Button("Teacher");
        Button btnRegister = new Button("Register");
        TextArea txtName = new TextArea();
        TextArea txtSurname = new TextArea();
        TextArea txtPassword = new TextArea();
        TextArea txtAccountName = new TextArea();

        pnlRegister.add(btnStudent);
        pnlRegister.add(btnTeacher);
        pnlInputTeacher.add(txtName);
        pnlInputTeacher.add(txtSurname);
        pnlInputTeacher.add(txtPassword);
        pnlInputTeacher.add(txtAccountName);

        registerTest.setVisible(true);
        registerTest.setSize(400,500);
        registerTest.setLocation(600, 660);

        registerTest.add(pnlRegister, BorderLayout.NORTH);
        registerTest.add(btnRegister, BorderLayout.SOUTH);
        registerTest.add(pnlInputTeacher, BorderLayout.CENTER);
    }
}