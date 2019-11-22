package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.model.user.Teacher;

import java.awt.*;

public class StudentSingleStatPanel extends BorderLayoutPanel {

    private Label lblSingleStat = new Label("Here will be shown the statistics of the student that you have chosen previously from the database!");
    private Panel pnlMain = new Panel();
    public StudentSingleStatPanel(Teacher teacher) {
        initPanelMain();
    }

    private void initPanelMain() {
        pnlMain.add(lblSingleStat, BorderLayout.CENTER);
        this.add(pnlMain, BorderLayout.CENTER);
    }
}
