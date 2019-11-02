package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.view.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends BaseFrame implements ActionListener {
    private Panel buttonPanel = new Panel();
    private Panel mainPanel = new Panel();
    private Panel teacherPanel = new TeacherPanel();
    private Panel studentPanel = new StudentPanel();
    private Panel registerPanel = new RegisterPanel();
    private Panel welcomePanel = new Panel();
    private Button btnRegister = new Button("Register");
    private Button btnTeacher = new Button("Teacher");
    private Button btnStudent = new Button("Student");

    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setVisible(true);
        this.setSize(1000, 700);

        this.setLayout(new BorderLayout());
        initButtons();
        initPanels();
    }

    private void initButtons() {
        btnRegister.addActionListener(this);
        btnStudent.addActionListener(this);
        btnTeacher.addActionListener(this);
        this.buttonPanel.add(btnRegister);
        this.buttonPanel.add(btnTeacher);
        this.buttonPanel.add(btnStudent);

    }

    private void initPanels() {
        initWelcomePanel();
        initRegisterPanel();
        initTeacherPanel();
        initStudentPanel();
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.add(welcomePanel, BorderLayout.CENTER);

    }

    private void initWelcomePanel() {

    }

    private void initRegisterPanel() {

    }

    private void initTeacherPanel() {

    }

    private void initStudentPanel() {

    }

    private void changeMainPanel(Panel newPanel){
        this.mainPanel.removeAll();
        this.mainPanel.add(newPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister){
            changeMainPanel(registerPanel);
        }
        else if (e.getSource() == btnTeacher) {
            changeMainPanel(teacherPanel);
        }
        else if (e.getSource() == btnStudent) {
            changeMainPanel(studentPanel);
        }

        this.mainPanel.validate();
        this.mainPanel.repaint();
    }
}
