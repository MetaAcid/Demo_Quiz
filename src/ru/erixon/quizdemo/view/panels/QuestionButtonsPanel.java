package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuestionButtonsPanel extends Panel implements ActionListener {
    private int size;
    private QuizPanel quizPanel;
    private List<Button> buttons = new ArrayList<>();


    public List<Button> getButtons() {
        return buttons;
    }

    public QuestionButtonsPanel(int size, QuizPanel quizPanel) {
        this.quizPanel=  quizPanel;
        this.setLayout(new GridLayout(size/3 + size%3, 3));
        this.size = size;
        initButtons();
        quizPanel.setQuestionButtonsPanel(this);
    }

    private void initButtons() {
        for (int i = 0; i < this.size; i++) {
            Button btn = new Button(String.valueOf(i+1));
            buttons.add(btn);
            btn.addActionListener(this);
            this.add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button) {
            Button btn = (Button) source;
            this.quizPanel.setCurrent(Integer.parseInt(btn.getLabel()) - 1);
            this.quizPanel.renderNextQuestion();
        }
    }
}
