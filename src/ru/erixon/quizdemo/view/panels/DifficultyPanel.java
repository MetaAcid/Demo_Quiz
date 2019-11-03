package ru.erixon.quizdemo.view.panels;

import java.awt.*;

public class DifficultyPanel extends BorderLayoutPanel {
    private Panel pnlMovement = new Panel();
    private Checkbox cbNormal = new Checkbox();
    private Checkbox cbEasy = new Checkbox();
    private Checkbox cbHard = new Checkbox();
    private Label lblNormal = new Label("Normal");
    private Label lblEasy = new Label("Easy");
    private Label lblHard = new Label("Hard");
    private Label lblDifficulty = new Label("Please, choose the difficulty of a Quiz:");
    private Button btnNext = new Button("Next");
    private Button btnBack = new Button("Back");
    private Panel pnlDifficulty = new Panel();
    private Panel pnlMain = new Panel();

    public DifficultyPanel() {
        pnlMain.add(pnlDifficulty, BorderLayout.CENTER);
        pnlMain.add(lblDifficulty, BorderLayout.NORTH);
        pnlMain.add(pnlMovement, BorderLayout.SOUTH);
        this.add(pnlMain);
        initDifficulty();
        initButtons();

    }

    private void initButtons() {
        pnlMovement.add(btnBack);
        pnlMovement.add(btnNext);
    }

    private void initDifficulty() {
        pnlDifficulty.add(lblHard);
        pnlDifficulty.add(cbHard);
        pnlDifficulty.add(lblNormal);
        pnlDifficulty.add(cbNormal);
        pnlDifficulty.add(lblEasy);
        pnlDifficulty.add(cbEasy);
    }

}