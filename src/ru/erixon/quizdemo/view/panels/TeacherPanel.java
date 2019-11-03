package ru.erixon.quizdemo.view.panels;

import javax.swing.*;
import java.awt.*;

public class TeacherPanel extends LogInPanel{
    private JLabel lblClassId = new JLabel("Class ID");
    private JTextField txtClassId = new JTextField();

    public TeacherPanel() {
        lblClassId.setBounds(xOff, yOff + 60, 100, 20);
        txtClassId.setBounds(xOff + 100, yOff + 60, 100, 20);
        this.add(lblClassId);
        this.add(txtClassId);
    }

    @Override
    protected boolean checkLogin() {
        return true;
    }

    @Override
    protected void doLogin() {
        throw new UnsupportedOperationException();
    }

}
