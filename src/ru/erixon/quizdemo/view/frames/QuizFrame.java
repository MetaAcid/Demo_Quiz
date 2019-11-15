package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;

import java.awt.*;
import ru.erixon.quizdemo.view.panels.QuizPanel;
import ru.erixon.quizdemo.view.panels.TimerPanel;

public class QuizFrame extends BaseFrame {
    private TimerPanel timerPanel = new TimerPanel(0, 100, 100);
    private QuizPanel pnlQuiz = new QuizPanel();

    public QuizFrame(String title) throws HeadlessException {
        super(title);
        this.setLayout(null);
        pnlQuiz.setBounds(500, 0, 500, 800);
        this.add(pnlQuiz);
        this.add(timerPanel);
        this.setVisible(true);
        this.setSize(1000, 800);
        this.setResizable(false);
    }
}
