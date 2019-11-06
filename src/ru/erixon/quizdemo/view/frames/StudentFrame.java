package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ru.erixon.quizdemo.view.panels.DifficultyPanel;
import ru.erixon.quizdemo.view.panels.StatisticsPanel;

public class StudentFrame extends BaseFrame implements ActionListener {
   private Button btnPlayQuiz = new Button("Play a Quiz!");
   private Button btnStudentStat = new Button("Your Statistics");
   private Button btnBack = new Button("Back");
   private Panel pnlMain = new Panel();
   private Panel pnlButton = new Panel();
   private DifficultyPanel pnlDifficulty = new DifficultyPanel();
   private StatisticsPanel pnlStatistics = new StatisticsPanel();
   private State state = State.INIT;

    public StudentFrame(Window owner, String title) throws HeadlessException {
        super(title);
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        initButtons();
        initPanels();
        checkBackButton();
    }

    private void initButtons() {
        btnPlayQuiz.addActionListener(this);
        btnStudentStat.addActionListener(this);
        btnBack.addActionListener(this);
        this.pnlButton.add(btnPlayQuiz);
        this.pnlButton.add(btnStudentStat);
        this.add(btnBack, BorderLayout.SOUTH);
    }

    private void initPanels() {
        this.pnlMain.add(pnlButton, BorderLayout.CENTER);
        this.add(pnlMain);
    }

    private void changeMainPanel(Panel newPanel){
        this.pnlMain.removeAll();
        this.pnlMain.add(newPanel);
    }

    private void checkBackButton(){
        if (state != State.INIT){
            btnBack.setVisible(true);
        }
        else {
            btnBack.setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPlayQuiz)) {
            changeMainPanel(pnlDifficulty);
            state = State.CHOOSE_DIFFICULTY;
        } else if (e.getSource().equals(btnStudentStat)) {
            changeMainPanel(pnlStatistics);
            state = State.STATISTICS;
        } else if (e.getSource().equals(btnBack)) {
            changeMainPanel(pnlButton);
            state = State.INIT;
        }
        checkBackButton();
        this.pnlMain.validate();
        this.pnlMain.repaint();
    }

    private enum State {
        INIT, CHOOSE_DIFFICULTY, STATISTICS
    }

}
