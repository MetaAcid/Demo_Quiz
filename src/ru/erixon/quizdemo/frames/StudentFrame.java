package ru.erixon.quizdemo.frames;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.panels.DifficultyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ru.erixon.quizdemo.panels.DifficultyPanel
import ru.erixon.quizdemo.panels.StatisticsPanel;

public class StudentFrame extends BaseFrame implements ActionListener {
   private Button btnPlayQuiz = new Button("Play a Quiz!");
   private Button btnStudentStat = new Button("Your Statistics");
   private Panel pnlMain = new Panel();
   private Panel pnlButton = new Panel();
   private Button btnBack = new Button("Back to Main Menu");
   private DifficultyPanel pnlDifficulty = new DifficultyPanel();
   private StatisticsPanel pnlStatistics = new StatisticsPanel();

    public StudentFrame(String title) throws HeadlessException {
        super(title);
        this.setVisible(true);
        this.setSize(1000, 700);

        initButton();
        initPanel();

    }

    private void initButton() {
        btnBack.addActionListener(this);
        btnPlayQuiz.addActionListener(this);
        btnStudentStat.addActionListener(this);
        this.pnlButton.add(btnPlayQuiz);
        this.pnlButton.add(btnStudentStat);
    }

    private void initPanel() {
        this.pnlMain.add(pnlButton, BorderLayout.CENTER);
        this.pnlMain.add(btnBack, BorderLayout.SOUTH);
    }

    private void changeMainPanel(Panel newPanel){
        this.pnlMain.removeAll();
        this.pnlMain.add(newPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPlayQuiz)) {
            changeMainPanel(pnlDifficulty);
        } else if (e.getSource().equals(btnStudentStat)) {
            changeMainPanel(pnlStatistics);
        }
        this.pnlMain.validate();
        this.pnlMain.repaint();
    }
}
