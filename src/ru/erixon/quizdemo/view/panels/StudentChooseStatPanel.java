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

    private JComboBox lstClass = new JComboBox();
    private JComboBox lstStudent = new JComboBox();
    private StudentDao studentDao = new StudentDao(Application.manager.getConnection());
    private JTable tblStat = new JTable(3,4);

    public StudentChooseStatPanel(Teacher teacher) {
        initComponents();
        initClassList();
        this.setBackground(Color.GRAY);
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

    private void initComponents() {
        Panel panel = new Panel();
        panel.add(lstClass);
        panel.add(lstStudent);
        this.add(panel, BorderLayout.NORTH);
        this.add(tblStat, BorderLayout.CENTER);
    }

    private void initListStudent() {
        List<Student> studentsByClass;
        lstStudent.removeAllItems();
        try {
            studentsByClass = studentDao.getStudentsByClass(lstClass.getSelectedItem().toString());
            for (Student s: studentsByClass) {
                lstStudent.addItem(s.getName() + s.getSurname());
            }
        } catch (SQLException | IOException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(lstClass)) {
            initListStudent();
        }
        else if (source.equals(lstStudent)){
            initTable();
        }
    }

    private void initTable() {

    }
}
