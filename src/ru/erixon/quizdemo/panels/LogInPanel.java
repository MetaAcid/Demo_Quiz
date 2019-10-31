package ru.erixon.quizdemo.panels;

import javax.swing.*;
import java.awt.*;

public abstract class LogInPanel extends BorderLayoutPanel {
    private TextField txtAcctName = new TextField();
    private JPasswordField txtPassword = new JPasswordField();
    private Button btnLogIn = new Button("Log In");
    protected Panel pnlCenter = new Panel();

    public LogInPanel() {
        pnlCenter.add(txtAcctName);
        pnlCenter.add(txtPassword);
        this.add(pnlCenter, BorderLayout.CENTER);
        this.add(btnLogIn , BorderLayout.SOUTH);
    }
}
