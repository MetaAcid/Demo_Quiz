package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public abstract class RegisterFormPanel extends Panel implements ActionListener {
    protected JLabel lblName = new JLabel("Name:");
    protected JLabel lblSurname = new JLabel("Surname:");
    protected JLabel lblPassword = new JLabel("Password:");
    protected JLabel lblAcctName = new JLabel("Account Name:");
    protected JTextField txtName = new JTextField(15);
    protected JTextField txtSurname = new JTextField(15);
    protected JPasswordField txtPassword = new JPasswordField(15);
    protected JTextField txtAcctName = new JTextField(15);
    protected Button btnRegister = new Button("Register");
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
        initActions();
    }

    protected abstract void doRegister() throws SQLException;

    private void initActions() {
        btnRegister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Object source = e.getSource();

            if (source.equals(btnRegister)) {
                MainFrame frame = new MainFrame("Main Menu");
                doRegister();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
