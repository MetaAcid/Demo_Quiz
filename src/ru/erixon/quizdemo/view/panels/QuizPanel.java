package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.view.frames.MainFrame;

public class QuizPanel extends BorderLayoutPanel implements ActionListener {
    private Label lblNumberOfQuestion = new Label("№ 'x' out of 'y'");
    private Label lblQuestion = new Label("What is 2 + 2?");
    private Label lblType = new Label("Please, type your answer here:");
    private TextField txtStudentAnswer = new TextField(15);
    private Button btnBackToMainMenu = new Button("Back to Main Menu");
    private Button btnSubmit = new Button("Submit Your Answer");
    private Panel pnlSouth = new Panel();
    private List<Question> questionList;
    private int current = 0;

    public QuizPanel(List<Question> questionList) {
        this.questionList = questionList;
//        this.setBackground(Color.GREEN);
        initSouth();
        initButtons();
        this.repaint();
    }

    private void initButtons() {
        btnBackToMainMenu.addActionListener(this);
        btnSubmit.addActionListener(this);
    }

    private void initSouth() {
        pnlSouth.add(btnBackToMainMenu);
        pnlSouth.add(btnSubmit);
        pnlSouth.add(lblType);
        pnlSouth.add(txtStudentAnswer);
        this.add(pnlSouth, BorderLayout.SOUTH);
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(this.questionList.get(current).getImage(),0,0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBackToMainMenu)) {
            MainFrame frame = new MainFrame("Main Menu");
        }
    }
}
