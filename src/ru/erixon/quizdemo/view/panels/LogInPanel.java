package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public abstract class LogInPanel<T extends User> extends Panel implements ActionListener {
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
        try {
            if (e.getSource() == this.btnLogIn) {
                login();
            }
        } catch (SQLException | IOException | ApplicationException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void login() throws SQLException, IOException, ApplicationException {
        T t = checkLogin();
        if (t != null) {
            doLogin(t);
        }
        else {
            throw new RuntimeException("Incorrect Log In or Password!");
        }
    }

    protected abstract T checkLogin() throws SQLException, IOException, ApplicationException;

    protected abstract void doLogin(T t);

}
