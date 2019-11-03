package ru.erixon.quizdemo.view.panels;

import javax.swing.*;

public class StudentRegisterFormPanel extends RegisterFormPanel {
    private JLabel lblClassID = new JLabel("Class ID:");
    private JTextField txtClassID = new JTextField(15);

    public StudentRegisterFormPanel() {
        lblClassID.setBounds(xOff, yOff + 120, 100, 20);
        txtClassID.setBounds(xOff+100, yOff + 120, 100, 20);
        this.add(lblClassID);
        this.add(txtClassID);
    }
}
