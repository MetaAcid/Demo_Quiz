package ru.erixon.quizdemo.view.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog extends Dialog implements ActionListener {
    private Button btnClose = new Button("Close");
    private Label lblMsg;
    private Exception exc;

    public ErrorDialog(Window owner, Exception exc) {
        super(owner, "error");
        this.setLayout(new GridLayout(1,2));
        this.exc = exc;
        lblMsg = new Label(exc.getMessage());
        initButtons();
        initLabels();
    }

    private void initLabels() {
        this.add(lblMsg);
    }


    private void initButtons() {
        btnClose.addActionListener(this);
        this.add(btnClose);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(btnClose)) {
            this.dispose();
        }
    }
}
