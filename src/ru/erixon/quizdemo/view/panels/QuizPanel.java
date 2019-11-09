package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;

public class QuizPanel extends BorderLayoutPanel implements ActionListener {
    private Label lblNumberOfQuestion = new Label("№ 'x' out of 'y'");
    private Label lblQuestion = new Label("What is 2 + 2?");
    private Label lblTypeStudent = new Label("Please, type your answer here:");
    private TextField txtStudentAnswer = new TextField(15);
    private Button btnBackToMainMenu = new Button("Back to Main Menu");
    private Button btnSubmit = new Button("Submit Your Answer");
    private Panel pnlQuiz = new Panel();
    private Panel pnlMovement = new Panel();
    private Panel pnlMain = new Panel();
    private Panel PanelMain = new Panel();

    public QuizPanel() {
        movementPanel();
        quizPanel();
        this.add(pnlMain);
        initButtons();
    }

    private void initButtons() {
        btnBackToMainMenu.addActionListener(this);
        btnSubmit.addActionListener(this);
    }

    private void movementPanel() {
        pnlMovement.add(btnBackToMainMenu, BorderLayout.EAST);
        pnlMovement.add(btnSubmit, BorderLayout.WEST);
        pnlMain.add(pnlMovement);
    }

    private void quizPanel() {
        pnlQuiz.add(lblNumberOfQuestion, BorderLayout.NORTH);
        pnlQuiz.add(lblQuestion, BorderLayout.CENTER);
        pnlQuiz.add(lblTypeStudent, BorderLayout.SOUTH);
        pnlQuiz.add(txtStudentAnswer, BorderLayout.SOUTH);
        pnlMain.add(pnlQuiz);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBackToMainMenu)) {
            MainFrame frame = new MainFrame("Main Menu");
        } else if (e.getSource().equals(btnSubmit)) {
            QuizFrame frame = new QuizFrame("Quiz Window");
        }
    }
}
