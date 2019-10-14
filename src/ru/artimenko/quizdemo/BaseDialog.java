package ru.artimenko.quizdemo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseDialog extends Dialog {
    private WindowAdapter windowAdapter;

    public BaseDialog(Window owner) {
        super(owner);

        this.windowAdapter =  new WindowAdapter() { //===MyWindowAdapter
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        };

        this.setModal(true);
        this.addWindowListener(windowAdapter);

    }
}
