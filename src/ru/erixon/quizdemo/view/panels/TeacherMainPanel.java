package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMainPanel extends BorderLayoutPanel implements ActionListener {
    private Button btnClassStat = new Button("Class Statistics");
    private Button btnStudentStat = new Button("Student Statistics");
    private ClassStatPanel classStatPanel = new ClassStatPanel();
    private StudentChooseStatPanel studentChooseStatPanel = new StudentChooseStatPanel();
    private Panel pnlTeacherMain = new Panel();

    public TeacherMainPanel() {
        initButtons();
    }

    private void initButtons() {
        btnClassStat.addActionListener(this);
        btnStudentStat.addActionListener(this);
        pnlTeacherMain.add(btnClassStat);
        pnlTeacherMain.add(btnStudentStat);
        this.add(pnlTeacherMain, BorderLayout.CENTER);
    }

    private void changeMainPanel(Panel newPanel){
        this.pnlTeacherMain.removeAll();
        this.pnlTeacherMain.add(newPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnClassStat)) {
            changeMainPanel(classStatPanel);
        } else if (e.getSource().equals(btnStudentStat)) {
            changeMainPanel(studentChooseStatPanel);
        }
    }
}
