package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionButtonsPanel extends Panel implements ActionListener {
    private int size;
    private QuizPanel quizPanel;
    public QuestionButtonsPanel(int size, QuizPanel quizPanel) {
        this.quizPanel=  quizPanel;
        this.setLayout(new GridLayout(size/3 + size%3, 3));
        this.size = size;
        initButtons();
    }

    private void initButtons() {
        for (int i = 0; i < this.size; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.addActionListener(this);
            this.add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button) {
            Button btn = (Button) source;
            this.quizPanel.setCurrent(Integer.parseInt(btn.getLabel()));
            this.quizPanel.repaint();
        }
    }
}
