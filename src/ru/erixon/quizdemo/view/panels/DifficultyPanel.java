package ru.erixon.quizdemo.view.panels;

import com.sun.org.apache.xpath.internal.operations.And;
import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.QuestionDao;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.user.Student;
import ru.erixon.quizdemo.view.frames.QuizFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DifficultyPanel extends Panel implements ActionListener {
    private CheckboxGroup checkboxGroup = new CheckboxGroup();
    protected Checkbox cbNormal = new Checkbox("Normal", checkboxGroup, false);
    protected Checkbox cbEasy = new Checkbox("Easy", checkboxGroup, false);
    protected Checkbox cbHard = new Checkbox("Hard", checkboxGroup, false);
    protected JLabel lblDifficulty = new JLabel("Please, choose the difficulty of a Quiz:");
    protected Button btnNext = new Button("Next");
    protected int xOff = 350;
    protected int yOff = 50;
    private QuestionDao questionDao = new QuestionDao(Application.manager.getConnection());
    private Student student;

    public DifficultyPanel(Student student) {
        this.setLayout(null);
        this.student = student;
        lblDifficulty.setBounds(xOff + 40, yOff, 400, 20);
        cbHard.setBounds(xOff + 100, yOff + 30, 100, 20);
        cbNormal.setBounds(xOff + 100, yOff + 60, 100, 20);
        cbEasy.setBounds(xOff + 100, yOff + 90, 100, 20);
        btnNext.setBounds(xOff + 40, yOff + 150, 200, 40);
        this.add(lblDifficulty);
        this.add(cbHard);
        this.add(cbNormal);
        this.add(cbEasy);
        this.add(btnNext);
        initButtons();
    }

    protected void initButtons() {
        btnNext.addActionListener(this);
    }

    private void initCheckBox() {

    }

    private Question.Difficulty getChosenDifficulty() {
        if (cbNormal.getState()) {
            return Question.Difficulty.NORMAL;
        } else if (cbEasy.getState()) {
            return Question.Difficulty.EASY;
        } else if (cbHard.getState()) {
            return Question.Difficulty.HARD;
        } else throw new RuntimeException();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnNext)) {
            List<Question> questions = questionDao.getQuestionsByParams(10, getChosenDifficulty());
            QuizFrame frame = new QuizFrame((Window) this.getFocusCycleRootAncestor(), "Quiz", questions, this.student);
        }
        this.validate();
        this.repaint();
    }
}
