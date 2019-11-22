package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.erixon.quizdemo.Application;
import ru.erixon.quizdemo.controller.database.dao.ResultsDao;
import ru.erixon.quizdemo.model.exceptions.ApplicationException;
import ru.erixon.quizdemo.model.question.Question;
import ru.erixon.quizdemo.model.results.TestResult;
import ru.erixon.quizdemo.model.user.Student;

public class QuizPanel extends BorderLayoutPanel implements ActionListener {
    private Label lblType = new Label("Please, type your answer here:");
    private TextField txtStudentAnswer = new TextField(15);
    private Button btnBackToMainMenu = new Button("Back to Main Menu");
    private Button btnSubmit = new Button("Submit Your Answer");
    private Panel pnlSouth = new Panel();
    private List<Question> questionList;
    private Map<Long,Boolean> resultsTable = new HashMap<>();
    private volatile int current = 0;
    private Student student;

    public void setCurrent(int current) {
        this.current = current;
    }

    public QuizPanel(List<Question> questionList, Student student) {
        this.questionList = questionList;
        this.student = student;
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

    private void submitAnswer() {
        String userInput = txtStudentAnswer.getText();
        Question question = questionList.get(current);
        if (userInput.toUpperCase().equals(question.getAnswer().toUpperCase())) {
            resultsTable.put(question.getId(), true);
        }
        else resultsTable.put(question.getId(), false);
    }

    public void onClose() throws SQLException, IOException, ApplicationException {
        ResultsDao resultsDao = new ResultsDao(Application.manager.getConnection());
        TestResult testResult = new TestResult(student, LocalDateTime.now(),resultsTable);
        resultsDao.insertResult(testResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(btnBackToMainMenu)) {
            try {
                onClose();
            } catch (SQLException | IOException | ApplicationException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(source.equals(btnSubmit)){
            submitAnswer();
        }
    }


}
