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
   private Panel pnlMain = new Panel(new BorderLayout());
   private DifficultyPanel pnlDifficulty = new DifficultyPanel();
   private StatisticsPanel pnlStatistics = new StatisticsPanel();
   private State state = State.INIT;
   protected int xOff = 350;
   protected int yOff = 50;

    public StudentFrame(Window owner, String title) throws HeadlessException {
        super(title);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1000, 700);
        this.setResizable(false);
        btnBack.setBounds(xOff, yOff - 600, 800, 40);
        btnPlayQuiz.setBounds(xOff, yOff, 400, 40);
        btnStudentStat.setBounds(xOff, yOff + 30, 400, 40);
        initButtons();
        initPanels();
        checkBackButton();
    }

    private void initButtons() {
        btnPlayQuiz.addActionListener(this);
        btnStudentStat.addActionListener(this);
        btnBack.addActionListener(this);
    }

    private void initPanels() {
        this.pnlMain.add(btnBack);
        this.pnlMain.add(btnPlayQuiz);
        this.pnlMain.add(btnStudentStat);
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
            changeMainPanel(pnlMain);
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
