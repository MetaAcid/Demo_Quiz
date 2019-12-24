package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.model.user.Teacher;
import ru.erixon.quizdemo.view.panels.StudentChooseStatPanel;
import ru.erixon.quizdemo.view.panels.ClassStatPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends BaseFrame implements ActionListener {

    private ClassStatPanel classStatPanel = new ClassStatPanel();
    private StudentChooseStatPanel studentChooseStatPanel;
    private Button btnStudentStat = new Button("Student Statistics");
    private Panel pnlButtons = new Panel();
    private TeacherFrame.State state = TeacherFrame.State.INIT;
    private Panel pnlMain = new Panel();
    private Teacher teacher;

    public TeacherFrame(Window owner, String title, Teacher teacher) throws HeadlessException {
        super(title);
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        studentChooseStatPanel = new StudentChooseStatPanel(teacher);
        initButtons();
        initPanels();
    }

    private void initButtons() {
        btnStudentStat.addActionListener(this);
        pnlButtons.add(btnStudentStat);
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
        if (e.getSource().equals(btnStudentStat)) {
            changeMainPanel(studentChooseStatPanel);
            state = State.CHOOSE_STUDENT_STAT;
            this.pnlMain.validate();
            this.pnlMain.repaint();
        }
    }

    private enum State {
        INIT, CHOOSE_STUDENT_STAT
    }

}
