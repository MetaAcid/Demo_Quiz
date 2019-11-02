package ru.erixon.quizdemo.view.panels;

import java.awt.*;

public class TeacherPanel extends LogInPanel {
    private TextField txtClassID = new TextField();

    public TeacherPanel() {
       this.pnlCenter.add(txtClassID);
    }
}
