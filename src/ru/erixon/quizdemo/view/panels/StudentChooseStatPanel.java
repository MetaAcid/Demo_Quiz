package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.StudentDao;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.Student;
import ru.erixon.quizdemo.model.user.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentChooseStatPanel extends BorderLayoutPanel implements ActionListener {

    private Label lblStuName = new Label("Student Name:");
    private Label lblClassID = new Label("Student Class:");
    private TextField txtStuName = new TextField(15);
    private TextField txtClassID = new TextField(15);
    private Panel pnlStudentInfo = new Panel();
    private Panel pnlMain = new Panel();
    private JComboBox lstClass = new JComboBox();
    private JComboBox lstStudent = new JComboBox();
    private StudentDao studentDao = new StudentDao(Application.manager.getConnection());

    public StudentChooseStatPanel(Teacher teacher) {
        studentInfo();
        initClassList();
        this.add(pnlMain, BorderLayout.CENTER);
    }

    private void initClassList() {
        lstClass.addActionListener(this);
        try {
            for (String s : studentDao.getClassList()) {
                lstClass.addItem(s);
            }
        } catch (SQLException | IOException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    private void studentInfo() {
        pnlStudentInfo.add(lblStuName);
        pnlStudentInfo.add(txtStuName);
        pnlStudentInfo.add(lblClassID);
        pnlStudentInfo.add(txtClassID);
        pnlStudentInfo.add(lstClass);
        pnlStudentInfo.add(lstStudent);
        pnlMain.add(pnlStudentInfo);
    }

    private void initListStudent() {
        List<Student> studentsByClass;
        try {
            studentsByClass = studentDao.getStudentsByClass(lstClass.getSelectedItem().toString());
        } catch (SQLException | IOException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println();
        if (e.getSource().equals(lstClass)) {

        }
    }
}
