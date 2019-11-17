package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.erixon.quizdemo.model.user.Student;
import ru.erixon.quizdemo.view.panels.DifficultyPanel;
import ru.erixon.quizdemo.view.panels.StatisticsPanel;

public class StudentFrame extends BaseFrame implements ActionListener {
   private Button btnPlayQuiz = new Button("Play a Quiz!");
   private Button btnStudentStat = new Button("Your Statistics");
   private Button btnBack = new Button("Back");
   private Panel pnlMain = new Panel(new BorderLayout());
   private Panel pnlButtons = new Panel(null);
   private DifficultyPanel pnlDifficulty;
   private StatisticsPanel pnlStatistics;
   private State state = State.INIT;
   protected int xOff = 350;
   protected int yOff = 50;
   private Student student;

    public StudentFrame(Window owner, String title, Student student) throws HeadlessException {
        super(title);
        this.student = student;
        initButtons();
        initPanels();
        checkBackButton();
        this.setSize(1000, 700);
        this.setResizable(false);
        this.setVisible(true);
        pnlStatistics = new StatisticsPanel(student);
        pnlDifficulty = new DifficultyPanel(student);
    }

    private void initButtons() {
        btnPlayQuiz.addActionListener(this);
        btnStudentStat.addActionListener(this);
        btnBack.addActionListener(this);
        btnBack.setBounds(xOff, yOff - 6, 800, 40);
        btnPlayQuiz.setBounds(xOff, yOff, 400, 40);
        btnStudentStat.setBounds(xOff, yOff + 30, 400, 40);
    }

    private void initPanels() {
        pnlButtons.add(btnBack);
        pnlButtons.add(btnPlayQuiz);
        pnlButtons.add(btnStudentStat);
        pnlMain.add(pnlButtons,BorderLayout.CENTER);
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
            changeMainPanel(pnlButtons);
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
