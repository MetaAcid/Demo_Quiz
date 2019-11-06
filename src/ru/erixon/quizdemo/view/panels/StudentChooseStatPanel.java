package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentChooseStatPanel extends BorderLayoutPanel{

    private Label lblStuName = new Label("Student Name:");
    private Label lblClassID = new Label("Student Class:");
    private TextField txtStuName = new TextField(15);
    private TextField txtClassID = new TextField(15);
    private Panel pnlStudentInfo = new Panel();
    private Panel pnlMain = new Panel();

    public StudentChooseStatPanel() {
        studentInfo();
        this.add(pnlMain, BorderLayout.CENTER);
    }

    private void studentInfo() {
        pnlStudentInfo.add(lblStuName);
        pnlStudentInfo.add(txtStuName);
        pnlStudentInfo.add(lblClassID);
        pnlStudentInfo.add(txtClassID);
        pnlMain.add(pnlStudentInfo);
    }

}
