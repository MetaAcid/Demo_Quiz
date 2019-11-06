package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.QuizFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends BorderLayoutPanel implements ActionListener {
    private Panel pnlMovement = new Panel();
    private Checkbox cbNormal = new Checkbox();
    private Checkbox cbEasy = new Checkbox();
    private Checkbox cbHard = new Checkbox();
    private JLabel lblNormal = new JLabel("Normal");
    private JLabel lblEasy = new JLabel("Easy");
    private JLabel lblHard = new JLabel("Hard");
    private JLabel lblDifficulty = new JLabel("Please, choose the difficulty of a Quiz:");
    private Button btnNext = new Button("Next");
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
        btnNext.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnNext)) {
            QuizFrame frame = new QuizFrame("Quiz");
        }
    }
}
