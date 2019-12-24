package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.ResultDetailsDao;
import ru.erixon.quizdemo.controller.database.dao.ResultsDao;
import ru.erixon.quizdemo.controller.database.dao.ResultsDao_old;
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

    private JComboBox<String> lstClass = new JComboBox<>();
    private JComboBox<Student> lstStudent = new JComboBox<>();
    private StudentDao studentDao = new StudentDao(Application.manager.getConnection());
    private ResultsDao resultsDao = new ResultsDao(Application.manager.getConnection());

    private ListCellRenderer<Student> studentComboBoxRenderer = new ListCellRenderer<Student>() {
        private DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();
        @Override
        public Component getListCellRendererComponent(JList<? extends Student> list, Student value, int index, boolean isSelected, boolean cellHasFocus) {
            return defaultListCellRenderer.getListCellRendererComponent(list, value.getSurname(), index, isSelected, cellHasFocus);
        }
    };
    private JTable tblStat = new JTable();

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
    }

    private void initListStudent() {
        lstStudent.addActionListener(this);
        List<Student> studentsByClass;
        lstStudent.removeAllItems();
        lstStudent.setRenderer(studentComboBoxRenderer);
        try {
            studentsByClass = studentDao.getStudentsByClass(lstClass.getSelectedItem().toString());
            for (Student s : studentsByClass) {
                lstStudent.addItem(s);
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
        } else if (source.equals(lstStudent)) {
            initTable();
        }
        repaint();
    }

    private void initTable() {
        String[] headers = {"Date", "Score", "Number of Questions"};
        String[][] data = resultsDao.getStudentStatisticsData((Student) lstStudent.getSelectedItem());
        tblStat = new JTable(data, headers);
        this.add(tblStat, BorderLayout.CENTER);
    }
}
