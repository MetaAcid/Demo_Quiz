package ru.erixon.quizdemo.panels;

import javafx.scene.layout.Pane;

import java.awt.*;

public class StatisticsPanel extends BorderLayoutPanel {
    private Label lblStat = new Label("Here will be shown your statistics from the database!");
    private Panel pnlMain = new Panel();

    public StatisticsPanel() {
        pnlMain.add(lblStat, BorderLayout.CENTER);
        this.add(pnlMain);
    }
}
