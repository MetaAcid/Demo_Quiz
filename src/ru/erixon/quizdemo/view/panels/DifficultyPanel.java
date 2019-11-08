package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.frames.QuizFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends Panel implements ActionListener {
    private CheckboxGroup checkboxGroup = new CheckboxGroup();
    protected Checkbox cbNormal = new Checkbox("Normal", checkboxGroup, false);
    protected Checkbox cbEasy = new Checkbox("Easy", checkboxGroup, false);
    protected Checkbox cbHard = new Checkbox("Hard", checkboxGroup, false);
    protected JLabel lblDifficulty = new JLabel("Please, choose the difficulty of a Quiz:");
    protected Button btnNext = new Button("Next");
    protected int xOff = 350;
    protected int yOff = 50;

    public DifficultyPanel() {
        this.setLayout(null);
        lblDifficulty.setBounds(xOff, yOff, 400, 20);
        cbHard.setBounds(xOff + 100, yOff + 30, 100, 20);
        cbNormal.setBounds(xOff + 100, yOff + 60, 100, 20);
        cbEasy.setBounds(xOff + 100, yOff + 90, 100, 20);
        btnNext.setBounds(xOff + 50, yOff + 150, 200, 40);
        this.add(lblDifficulty);
        this.add(cbHard);
        this.add(cbNormal);
        this.add(cbEasy);
        this.add(btnNext);
        initButtons();
    }

    protected void initButtons() {
        btnNext.addActionListener(this);
    }

    private void initCheckBox() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnNext)) {
            QuizFrame frame = new QuizFrame("Quiz");
        }
        this.validate();
        this.repaint();
    }
}
