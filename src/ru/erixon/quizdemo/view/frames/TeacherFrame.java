package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.view.panels.ClassStatPanel;
import ru.erixon.quizdemo.view.panels.StudentStatPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends BaseFrame implements ActionListener {
    private Button btnClassStat = new Button("Class Statistics");
    private Button btnStudentStat = new Button("Student Statistics");
    private ClassStatPanel classStatPanel = new ClassStatPanel();
    private StudentStatPanel studentStatPanel = new StudentStatPanel();
    private Panel pnlMain = new Panel();

    public TeacherFrame(String title) throws HeadlessException {
        super(title);
        initButtons();
        this.setSize(700,700);
        this.setVisible(true);
    }

    private void initButtons() {
        btnClassStat.addActionListener(this);
        btnStudentStat.addActionListener(this);
        pnlMain.add(btnClassStat);
        pnlMain.add(btnStudentStat);
        this.add(pnlMain, BorderLayout.CENTER);
    }

    private void changeMainPanel(Frame newFrame){
        this.pnlMain.removeAll();
        this.pnlMain.add(newFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnClassStat)) {
//            changeMainPanel(classStatPanel);
        } else if (e.getSource().equals(btnStudentStat)) {
//            changeMainPanel(studentStatPanel);
        }
    }
}
