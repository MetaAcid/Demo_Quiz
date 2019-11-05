package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.panels.TeacherMainPanel;
import ru.erixon.quizdemo.view.panels.StudentSingleStatPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentChooseStatPanel extends BorderLayoutPanel implements ActionListener {
    private TeacherMainPanel teacherMainPanel = new TeacherMainPanel();
    private StudentSingleStatPanel studentSingleStatPanel = new StudentSingleStatPanel();
    private Label lblStuName = new Label("Student Name:");
    private Label lblClassID = new Label("Student Class:");
    private TextField txtStuName = new TextField();
    private TextField txtClassID = new TextField();
    private Button btnBack = new Button("Back");
    private Button btnNext = new Button("Next");
    private Panel pnlMovement = new Panel();
    private Panel pnlStudentInfo = new Panel();
    private Panel pnlMain = new Panel();

    public StudentChooseStatPanel() {
        initMovement();
        studentInfo();
        this.add(pnlMain, BorderLayout.CENTER);
    }

    private void initMovement() {
        btnBack.addActionListener(this);
        btnNext.addActionListener(this);
        pnlMovement.add(btnBack);
        pnlMovement.add(btnNext);
        pnlMain.add(pnlMovement);
    }

    private void studentInfo() {
        pnlStudentInfo.add(lblStuName);
        pnlStudentInfo.add(txtStuName);
        pnlStudentInfo.add(lblClassID);
        pnlStudentInfo.add(txtClassID);
        pnlMain.add(pnlStudentInfo);
    }

    private void changeMainPanel(Panel newPanel){
        this.pnlMain.removeAll();
        this.pnlMain.add(newPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnNext)) {
            changeMainPanel(studentSingleStatPanel);
        } else if (e.getSource().equals(btnBack)) {
            changeMainPanel(teacherMainPanel);
        }
    }
}
