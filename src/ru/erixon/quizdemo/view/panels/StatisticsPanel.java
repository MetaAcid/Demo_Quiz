package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.model.user.Student;

import java.awt.*;

public class StatisticsPanel extends BorderLayoutPanel {
    private Label lblStat = new Label("Here will be shown your statistics from the database!");
    private Panel pnlMain = new Panel();
    private Student student;
    public StatisticsPanel(Student student) {
        pnlMain.add(lblStat, BorderLayout.CENTER);
        this.add(pnlMain);
        this.student = student;
    }
}
