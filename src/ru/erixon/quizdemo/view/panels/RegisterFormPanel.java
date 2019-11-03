package ru.erixon.quizdemo.view.panels;

import javax.swing.*;
import java.awt.*;

public abstract class RegisterFormPanel extends Panel {
    private JLabel lblName = new JLabel("Name:");
    private JLabel lblSurname = new JLabel("Surname:");
    private JLabel lblPassword = new JLabel("Password:");
    private JLabel lblAcctName = new JLabel("Account Name:");
    private JTextField txtName = new JTextField(15);
    private JTextField txtSurname = new JTextField(15);
    private JPasswordField txtPassword = new JPasswordField(15);
    private JTextField txtAcctName = new JTextField(15);
    private Button btnRegister = new Button("Register");
    protected int xOff = 350;
    protected int yOff = 50;

    public RegisterFormPanel() {
        this.setLayout(null);
        lblName.setBounds(xOff, yOff, 100, 20);
        lblSurname.setBounds(xOff, yOff + 30, 100, 20);
        lblPassword.setBounds(xOff, yOff + 60, 100, 20);
        lblAcctName.setBounds(xOff, yOff + 90, 100, 20);
        txtName.setBounds(xOff+100, yOff, 100, 20);
        txtSurname.setBounds(xOff+100, yOff+30, 100, 20);
        txtPassword.setBounds(xOff+100, yOff + 60, 100, 20);
        txtAcctName.setBounds(xOff+100, yOff + 90, 100, 20);
        btnRegister.setBounds(xOff, yOff + 150, 200, 40);
        this.add(lblName);
        this.add(txtName);
        this.add(lblSurname);
        this.add(txtSurname);
        this.add(lblAcctName);
        this.add(txtAcctName);
        this.add(lblPassword);
        this.add(txtPassword);

        this.add(btnRegister);
    }
}
