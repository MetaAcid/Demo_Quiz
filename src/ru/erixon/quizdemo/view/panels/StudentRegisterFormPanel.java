package ru.erixon.quizdemo.view.panels;

import java.awt.*;

public class StudentRegisterFormPanel extends RegisterFormPanel {
    private Label lblClassID = new Label("Class ID:");
    private TextField txtClassID = new TextField(15);

    public StudentRegisterFormPanel() {
        this.pnlRegisterInfo.add(lblClassID);
        this.pnlRegisterInfo.add(txtClassID);
    }
}
