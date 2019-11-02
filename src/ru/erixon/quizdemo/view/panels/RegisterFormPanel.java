package ru.erixon.quizdemo.view.panels;

import javax.swing.*;
import java.awt.*;

public abstract class RegisterFormPanel extends Panel {
    private Label lblName = new Label("Name:");
    private Label lblSurname = new Label("Surname:");
    private Label lblPassword = new Label("Password:");
    private Label lblAcctName = new Label("Account Name:");
    private TextField txtName = new TextField(15);
    private TextField txtSurname = new TextField(15);
    private JPasswordField txtPassword = new JPasswordField(15);
    private TextField txtAcctName = new TextField(15);
    protected Panel pnlRegisterInfo = new Panel();
    private Button btnRegister = new Button("Register");

    public RegisterFormPanel() {
        pnlRegisterInfo.add(lblName);
        pnlRegisterInfo.add(txtName);
        pnlRegisterInfo.add(lblSurname);
        pnlRegisterInfo.add(txtSurname);
        pnlRegisterInfo.add(lblAcctName);
        pnlRegisterInfo.add(txtAcctName);
        pnlRegisterInfo.add(lblPassword);
        pnlRegisterInfo.add(txtPassword);
        this.add(pnlRegisterInfo, BorderLayout.CENTER);
        this.add(btnRegister, BorderLayout.SOUTH);
    }
}
