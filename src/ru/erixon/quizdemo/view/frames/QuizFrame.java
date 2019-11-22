package ru.erixon.quizdemo.view.frames;

import java.awt.*;
import java.util.List;

import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.user.Student;
import ru.erixon.quizdemo.view.panels.QuestionButtonsPanel;
import ru.erixon.quizdemo.view.panels.QuizPanel;
import ru.erixon.quizdemo.view.panels.TimerPanel;

import javax.swing.*;

public class QuizFrame extends JDialog {
    private TimerPanel timerPanel = new TimerPanel(0, 20, 100);
    private QuizPanel pnlQuiz;
    private QuestionButtonsPanel pnlButton;

    public QuizFrame(Window owner, String title, List<Question> questions, Student student) throws HeadlessException {
        super(owner, title);
        pnlQuiz = new QuizPanel(questions, student);
        initButtonPanel(questions.size());
        this.setLayout(null);
        pnlQuiz.setBounds(200, 0, 1300, 950);
        this.setSize(1500, 1000);
        this.add(pnlQuiz);
        this.add(timerPanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setModal(true);
    }

    private void initButtonPanel(int size) {
        this.pnlButton = new QuestionButtonsPanel(size, pnlQuiz);
        this.pnlButton.setBounds(0,300, 200,700);
        this.add(pnlButton);
    }
}
