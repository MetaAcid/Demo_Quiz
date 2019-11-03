package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentStatPanel extends BorderLayoutPanel implements ActionListener {
    private Label lblStuName = new Label("Student Name:");
    private Label lblClassID = new Label("Student Class:");
    private TextField txtStuName = new TextField();
    private TextField txtClassID = new TextField();
    private Button btnBack = new Button("Back");
    private Button btnNext = new Button("Next");
    private Panel pnlMovement = new Panel();
    private Panel pnlStudentInfo = new Panel();
    private Panel pnlMain = new Panel();

    public StudentStatPanel() {
        initMovement();
        studentInfo();
    }

    private void initMovement() {
        btnBack.addActionListener(this);
        btnNext.addActionListener(this);
        pnlMovement.add(btnBack);
        pnlMovement.add(btnNext);
        pnlMain.add(pnlMovement);
    }

    private void studentInfo() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
