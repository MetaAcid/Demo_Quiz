package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuestionButtonsPanel extends Panel implements ActionListener {
    protected int size;
    private QuizPanel quizPanel;
    private boolean[] blackList;
    protected List<Button> buttons = new ArrayList<>();
    public boolean[] getBlackList() {
        return blackList;
    }

    public QuestionButtonsPanel(int size, QuizPanel quizPanel) {
        blackList = new boolean[size];
        this.quizPanel=  quizPanel;
        this.setLayout(new GridLayout(size/3 + size%3, 3));
        this.size = size;
        initButtons();
        quizPanel.setQuestionButtonsPanel(this);
    }

    private void initButtons() {
        for (int i = 0; i < this.size; i++) {
            Button btn = new Button(String.valueOf(i));
            buttons.add(btn);
            btn.addActionListener(this);
            this.add(btn);
        }
    }

    @Override
    public void paint(Graphics g) {
        Color color = Color.GRAY;
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            if (blackList[i]){
                button.setBackground(color);
                button.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button) {
            Button btn = (Button) source;
            this.quizPanel.setCurrent(Integer.parseInt(btn.getLabel()));
            this.quizPanel.renderNextQuestion();
        }
    }
}
