package ru.erixon.quizdemo.view.panels;

import java.awt.*;

public class ClassStatPanel extends BorderLayoutPanel {
    private Label lblMessage = new Label("Here will be the statistics of the class based on the data in the database!");
    private Panel pnlMessage = new Panel();

    public ClassStatPanel() {
        pnlMessage.add(lblMessage);
        this.add(pnlMessage, BorderLayout.CENTER);
    }
}
