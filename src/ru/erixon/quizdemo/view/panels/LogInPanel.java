package ru.erixon.quizdemo.view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class LogInPanel extends Panel implements ActionListener {
    protected JLabel lblAcctName = new JLabel("Account Name:");
    protected JLabel lblPassword = new JLabel("Password:");
    protected JTextField txtAcctName = new JTextField();
    protected JPasswordField txtPassword = new JPasswordField(15);
    protected Button btnLogIn = new Button("Log In");
    protected int xOff = 350;
    protected int yOff = 50;

    public LogInPanel() {
        this.setLayout(null);
        lblAcctName.setBounds(xOff, yOff, 100,20);
        lblPassword.setBounds(xOff,yOff + 30,100,20);
        txtAcctName.setBounds(xOff + 100,yOff,100,20);
        txtPassword.setBounds(xOff + 100,yOff + 30,100,20);
        btnLogIn.setBounds(xOff , yOff + 90, 200, 40);
        this.add(lblAcctName);
        this.add(lblPassword);
        this.add(txtAcctName);
        this.add(txtPassword);
        this.add(btnLogIn);
        registerActions();
    }

    protected void registerActions() {
        btnLogIn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnLogIn) {
            login();
        }
    }

    protected void login(){
        if (checkLogin()) {
            doLogin();
        }
        else {
            throw new RuntimeException("Неверный логин или пароль!");
        }
    }

    protected abstract boolean checkLogin();

    protected abstract void doLogin();

}
