package ru.erixon.quizdemo.view.frames;

import java.awt.*;
import java.util.List;

import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.view.panels.QuizPanel;
import ru.erixon.quizdemo.view.panels.TimerPanel;

import javax.swing.*;

public class QuizFrame extends JDialog {
    private TimerPanel timerPanel = new TimerPanel(0, 100, 100);
    private QuizPanel pnlQuiz;

    public QuizFrame(Window owner, String title, List<Question> questions) throws HeadlessException {
        super(owner, title);
        pnlQuiz = new QuizPanel(questions);
        this.setLayout(null);
        pnlQuiz.setBounds(200, 0, 1300, 950);
        this.setSize(1500, 1000);
        this.add(pnlQuiz);
        this.add(timerPanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setModal(true);
    }
}
