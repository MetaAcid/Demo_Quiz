package ru.artimenko.quizdemo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseFrame extends Frame {

    private WindowAdapter windowAdapter;

    public BaseFrame(String title) throws HeadlessException {
        super(title);
        this.windowAdapter =  new WindowAdapter() { //===MyWindowAdapter
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        };

        this.addWindowListener(windowAdapter);
    }



    private class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            dispose();
        }
    }

}
