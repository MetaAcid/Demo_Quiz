package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.view.panels.StudentChooseStatPanel;
import ru.erixon.quizdemo.view.panels.ClassStatPanel;
import ru.erixon.quizdemo.view.panels.StudentSingleStatPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends BaseFrame implements ActionListener {

    private ClassStatPanel classStatPanel = new ClassStatPanel();
    private StudentChooseStatPanel studentChooseStatPanel = new StudentChooseStatPanel();
    private StudentSingleStatPanel studentSingleStatPanel = new StudentSingleStatPanel();
    private Button btnClassStat = new Button("Class Statistics");
    private Button btnStudentStat = new Button("Student Statistics");
    private Panel pnlButtons = new Panel();
    private Button btnBack = new Button("Back");
    private TeacherFrame.State state = TeacherFrame.State.INIT;
    private Panel pnlMain = new Panel();
    private Button btnNext = new Button("Next");

    public TeacherFrame(String title) throws HeadlessException {
        super(title);
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        initButtons();
        initPanels();
        checkBackButton();
        checkNextButton();
    }

    private void initButtons() {
        btnClassStat.addActionListener(this);
        btnStudentStat.addActionListener(this);
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
        pnlButtons.add(btnStudentStat);
        pnlButtons.add(btnClassStat);
        this.add(btnBack, BorderLayout.SOUTH);
        this.add(btnNext, BorderLayout.NORTH);
    }

    private void checkNextButton(){
        if (state == State.CHOOSE_STUDENT_STAT){
            btnNext.setVisible(true);
        }
        else {
            btnNext.setVisible(false);
        }
    }

    private void checkBackButton(){
        if (state != TeacherFrame.State.INIT){
            btnBack.setVisible(true);
        }
        else {
            btnBack.setVisible(false);
        }
    }

    private void initPanels() {
        this.pnlMain.add(pnlButtons, BorderLayout.CENTER);
        this.add(pnlMain);
    }

    private void changeMainPanel(Panel newPanel){
        this.pnlMain.removeAll();
        this.pnlMain.add(newPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnClassStat)) {
            changeMainPanel(classStatPanel);
            state = State.CLASS_STAT;
        } else if (e.getSource().equals(btnStudentStat)) {
            changeMainPanel(studentChooseStatPanel);
            state = State.CHOOSE_STUDENT_STAT;
        } else if (e.getSource().equals(btnBack)) {
            changeMainPanel(pnlButtons);
            state = State.INIT;
        } else if (e.getSource().equals(btnNext)) {
            changeMainPanel(studentSingleStatPanel);
            state = State.STUDENT_STAT;
        }
        checkBackButton();
        checkNextButton();
        this.pnlMain.validate();
        this.pnlMain.repaint();
    }


    private enum State {
        INIT, STUDENT_STAT, CLASS_STAT, CHOOSE_STUDENT_STAT
    }

}
