package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.QuizFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends BorderLayoutPanel implements ActionListener {
    private JCheckBox cbNormal = new JCheckBox();
    private JCheckBox cbEasy = new JCheckBox();
    private JCheckBox cbHard = new JCheckBox();
    private JLabel lblNormal = new JLabel("Normal");
    private JLabel lblEasy = new JLabel("Easy");
    private JLabel lblHard = new JLabel("Hard");
    private JLabel lblDifficulty = new JLabel("Please, choose the difficulty of a Quiz:");
    private Button btnNext = new Button("Next");
    protected int xOff = 350;
    protected int yOff = 50;

    public DifficultyPanel() {
        this.setLayout(null);
        lblDifficulty.setBounds(xOff, yOff, 100, 20);
        lblHard.setBounds(xOff, yOff + 30, 100, 20);
        cbHard.setBounds(xOff + 100, yOff + 30, 100, 20);
        lblNormal.setBounds(xOff, yOff +60, 100, 20);
        cbNormal.setBounds(xOff + 100, yOff + 60, 100, 20);
        lblEasy.setBounds(xOff, yOff + 90, 100, 20);
        cbEasy.setBounds(xOff + 100, yOff + 90, 100, 20);
        this.add(lblDifficulty);
        this.add(lblHard);
        this.add(cbHard);
        this.add(lblNormal);
        this.add(cbNormal);
        this.add(lblEasy);
        this.add(cbEasy);
        initButtons();
        btnNext.setBounds(xOff + 50, yOff + 150, 200, 40);
        this.add(btnNext);
    }

    private void initButtons() {
        btnNext.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnNext)) {
            QuizFrame frame = new QuizFrame("Quiz");
        }
    }
}
