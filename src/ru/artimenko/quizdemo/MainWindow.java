package ru.artimenko.quizdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends BaseFrame implements ActionListener {
    private Panel mainPanel= new Panel();
    private Panel teacherPanel = new Panel();
    private Panel studentPanel = new Panel();
    private Panel welcomePanel = new Panel();
    private Panel registerPanelTeacher = new Panel();
    private Panel registerPanelStudent = new Panel();
    private Button btnRegister = new Button("Register");
    private Button btnTeacher = new Button("Teacher");
    private Button btnStudent = new Button("Student");

    public MainWindow(String title) throws HeadlessException {
        super(title);

        Label lblWelcome = new Label("Welcome to a Math Quiz!");
        Panel buttonPanel = new Panel();
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
        Panel pnlStuLogIn = new Panel();
        TextArea txtStuAccountName = new TextArea();
        TextArea txtStuPassword = new TextArea();
        Button btnTeacherLogIn = new Button("Log In");
        Panel pnlTeachLogIn = new Panel();
        Button btnTeachLogIn = new Button("Log In");
        TextArea txtTeachAccountName = new TextArea();
        TextArea txtTeachPassword = new TextArea();
        TextArea txtTeachClassID = new TextArea();
        btnTeacher.addActionListener(this);
        btnRegister.addActionListener(this);
        btnStudent.addActionListener(this);
        welcomePanel.add(lblWelcome);
        this.setVisible(true);
        this.setSize(500,600);
        buttonPanel.setLayout(new GridLayout(1,3));
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnStudent);
        buttonPanel.add(btnTeacher);
        mainPanel.add(welcomePanel);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        registerPanelStudent.add(pnlRegisterStudent, BorderLayout.NORTH);
        registerPanelStudent.add(pnlInputStudent, BorderLayout.CENTER);
        registerPanelStudent.add(btnRegister, BorderLayout.SOUTH);
        pnlRegister.add(btnStudentRegister);
        pnlRegister.add(btnTeacherRegister);
        pnlInputStudent.add(txtNameStudent);
        pnlInputStudent.add(txtSurnameStudent);
        pnlInputStudent.add(txtPasswordStudent);
        pnlInputStudent.add(txtClassID);
        pnlInputTeacher.add(txtNameTeacher);
        pnlInputTeacher.add(txtSurnameTeacher);
        pnlInputTeacher.add(txtPasswordTeacher);
        pnlInputTeacher.add(txtAccountName);
        registerPanelTeacher.add(pnlRegisterTeacher, BorderLayout.NORTH);
        registerPanelTeacher.add(btnRegister, BorderLayout.SOUTH);
        registerPanelTeacher.add(pnlInputTeacher, BorderLayout.CENTER);
        pnlStuLogIn.add(txtStuAccountName);
        pnlStuLogIn.add(txtStuPassword);
        studentPanel.add(pnlStuLogIn, BorderLayout.CENTER);
        studentPanel.add(btnTeacherLogIn, BorderLayout.SOUTH);
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
        this.mainPanel.validate();
        this.mainPanel.repaint();
    }
}
