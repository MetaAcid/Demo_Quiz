package ru.erixon.quizdemo.view.panels;

import javax.swing.*;
import java.awt.*;

public abstract class LogInPanel extends BorderLayoutPanel {
    private Label lblAcctName = new Label("Account Name:");
    private Label lblPassword = new Label("Password:");
    private TextField txtAcctName = new TextField(15);
    private JPasswordField txtPassword = new JPasswordField(15);
    protected Button btnLogIn = new Button("Log In");
    protected Panel pnlCenter = new Panel();

    public LogInPanel() {
        pnlCenter.add(lblAcctName);
        pnlCenter.add(txtAcctName);
        pnlCenter.add(lblPassword);
        pnlCenter.add(txtPassword);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(btnLogIn , BorderLayout.SOUTH);
    }
}
