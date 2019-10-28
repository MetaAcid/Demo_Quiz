package ru.artimenko.quizdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends BaseFrame implements ActionListener {
    Panel mainPanel= new Panel();
    Panel teacherPanel = new Panel();
    Panel studentPanel = new Panel();
    Panel welcomePanel = new Panel();
    Panel registerPanel = new Panel();
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
        registerPanel.add(new Label("I am Refister label"));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegister) {
            this.mainPanel.removeAll();
            this.mainPanel.add(registerPanel);
        }
//        repaint();
        this.mainPanel.repaint();
    }
}
