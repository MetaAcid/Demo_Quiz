package ru.artimenko.quizdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends BaseFrame implements ActionListener {
    Panel mainPanel= new Panel();
    Panel teacherPanel = new Panel();
    Panel studentPanel = new Panel();
    Panel welcomePanel = new Panel();
    Panel registerPanelTeacher = new Panel();
    Panel registerPanelStudent = new Panel();
    Button btnRegister = new Button("Register");
    Button btnTeacher = new Button("Teacher");
    Button btnStudent = new Button("Student");

    public MainWindow(String title) throws HeadlessException {
        super(title);

        btnTeacher.addActionListener(this);
        btnRegister.addActionListener(this);
        btnStudent.addActionListener(this);
        Label lblWelcome = new Label("Welcome to a Math Quiz!");
        Panel buttonPanel = new Panel();
        welcomePanel.add(lblWelcome);
        this.setVisible(true);
        this.setSize(500, 600);

        buttonPanel.setLayout(new GridLayout(1,3));
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnStudent);
        buttonPanel.add(btnTeacher);

        mainPanel.add(welcomePanel);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);

        Panel pnlRegisterTeacher = new Panel();
        Panel pnlInputTeacher = new Panel();
        TextArea txtNameTeacher = new TextArea();
        TextArea txtSurnameTeacher = new TextArea();
        TextArea txtPasswordTeacher = new TextArea();
        TextArea txtAccountName = new TextArea();
        Button btnTeacherRegister = new Button("Teacher");
        Button btnStudentRegister = new Button("Student");
        Panel pnlRegister = new Panel();
        Panel pnlRegisterStudent = new Panel();
        Panel pnlInputStudent = new Panel();
        TextArea txtNameStudent = new TextArea();
        TextArea txtSurnameStudent = new TextArea();
        TextArea txtPasswordStudent = new TextArea();
        TextArea txtClassID = new TextArea();

        registerPanelStudent.add(pnlRegisterStudent, BorderLayout.NORTH);
        registerPanelStudent.add(pnlInputStudent, BorderLayout.CENTER);
        registerPanelStudent.add(btnRegister, BorderLayout.SOUTH);

        pnlRegister.add(btnStudent);
        pnlRegister.add(btnTeacher);
        pnlInputStudent.add(txtNameStudent);
        pnlInputStudent.add(txtSurnameStudent);
        pnlInputStudent.add(txtPasswordStudent);
        pnlInputStudent.add(txtClassID);

        pnlRegisterTeacher.add(btnStudentRegister);
        pnlRegisterTeacher.add(btnTeacherRegister);
        pnlInputTeacher.add(txtNameTeacher);
        pnlInputTeacher.add(txtSurnameTeacher);
        pnlInputTeacher.add(txtPasswordTeacher);
        pnlInputTeacher.add(txtAccountName);
        registerPanelTeacher.add(pnlRegisterTeacher, BorderLayout.NORTH);
        registerPanelTeacher.add(btnRegister, BorderLayout.SOUTH);
        registerPanelTeacher.add(pnlInputTeacher, BorderLayout.CENTER);

        Panel pnlStuLogIn = new Panel();
        TextArea txtStuAccountName = new TextArea();
        TextArea txtStuPassword = new TextArea();
        Button btnTeacherLogIn = new Button();

        pnlStuLogIn.add(txtStuAccountName);
        pnlStuLogIn.add(txtStuPassword);
        studentPanel.add(pnlStuLogIn, BorderLayout.CENTER);
        studentPanel.add(btnTeacherLogIn, BorderLayout.SOUTH);

        Panel pnlTeachLogIn = new Panel();
        Button btnTeachLogIn = new Button();
        TextArea txtTeachAccountName = new TextArea();
        TextArea txtTeachPassword = new TextArea();
        TextArea txtTeachClassID = new TextArea();

        pnlTeachLogIn.add(txtTeachAccountName);
        pnlTeachLogIn.add(txtTeachClassID);
        pnlTeachLogIn.add(txtTeachPassword);
        teacherPanel.add(pnlTeachLogIn, BorderLayout.CENTER);
        teacherPanel.add(btnTeachLogIn, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent) {
            this.mainPanel.removeAll();
            this.mainPanel.add(studentPanel);
        } else if (e.getSource() == btnTeacher) {
            this.mainPanel.removeAll();
            this.mainPanel.add(teacherPanel);
        } else if (e.getSource() == btnRegister) {
            Button btnTeacherRegister = new Button("Teacher");
            Button btnStudentRegister = new Button("Student");
            btnTeacherRegister.addActionListener(this);
            btnStudentRegister.addActionListener(this);

            Panel buttonPanelRegister = new Panel();
            buttonPanelRegister.add(btnStudentRegister);
            buttonPanelRegister.add(btnTeacherRegister);
            buttonPanelRegister.setLayout(new GridLayout(1,2));
            this.add(buttonPanelRegister, BorderLayout.NORTH);

            if (e.getSource() == btnTeacherRegister) {
                this.mainPanel.removeAll();
                this.mainPanel.add(registerPanelTeacher);
            } else {
                this.mainPanel.removeAll();
                this.mainPanel.add(registerPanelStudent);
            }
        }
        this.mainPanel.repaint();
    }
}