package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.StudentFrame;

import java.awt.event.ActionListener;

public class StudentPanel extends LogInPanel implements ActionListener {

    public StudentPanel() {}

    @Override
    protected boolean checkLogin() {
        return true;
    }

    @Override
    protected void doLogin() {
        StudentFrame frame = new StudentFrame(null, "Student Window");
    }
}
