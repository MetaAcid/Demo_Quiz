package ru.erixon.quizdemo.view.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    private TextField txtStudentAnswer = new TextField(50);
    private Button btnBackToMainMenu = new Button("Back to Main Menu");
    private Button btnSubmit = new Button("Submit Your Answer");
    private Panel pnlSouth = new Panel();
    private List<Question> questionList;
    private Map<Long,Boolean> resultsTable = new HashMap<>();
    private volatile int current = 0;
    private Student student;
    private int image_width = 800;
    private int image_height = 800;
    private QuestionButtonsPanel questionButtonsPanel;

    public void setQuestionButtonsPanel(QuestionButtonsPanel questionButtonsPanel) {
        this.questionButtonsPanel = questionButtonsPanel;
    }

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
        pnlSouth.setLayout(null);
//        pnlSouth.setBackground(Color.GREEN);
        pnlSouth.setSize(this.getWidth(), 200);
        lblType.setBounds(400, 0, image_width, 20);
        txtStudentAnswer.setBounds(400, 30, image_width, 170);
        btnSubmit.setBounds(image_width + 400 + 100, 30, 200, 70);
        btnBackToMainMenu.setBounds(image_width + 400 + 100, 130, 200, 70);
        pnlSouth.add(lblType);
        pnlSouth.add(txtStudentAnswer);
        pnlSouth.add(btnBackToMainMenu);
        pnlSouth.add(btnSubmit);
        this.add(pnlSouth, BorderLayout.SOUTH);
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage image = this.questionList.get(current).getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        float scaleFactor = (float) image_height/height;
        Image scaledImage = image.getScaledInstance(Math.round(width*scaleFactor), Math.round(height*scaleFactor), Image.SCALE_DEFAULT);
        g.drawImage(scaledImage,0,0, null);
    }

    private void submitAnswer() {
        String userInput = txtStudentAnswer.getText();
        Question question = questionList.get(current);

        questionButtonsPanel.getBlackList()[current] = true;
        questionButtonsPanel.repaint();

        if (userInput.toUpperCase().equals(question.getAnswer().toUpperCase())) {
            resultsTable.put(question.getId(), true);
        }
        else resultsTable.put(question.getId(), false);

        checkAllQuestionsIsAnswered();
    }

    private void checkAllQuestionsIsAnswered() {
        if (resultsTable.size() == questionList.size()) {
            try {
                onClose();
            } catch (SQLException | IOException | ApplicationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onClose() throws SQLException, IOException, ApplicationException {
        ResultsDao resultsDao = new ResultsDao(Application.manager.getConnection());
        TestResult testResult = new TestResult(student, LocalDateTime.now(),resultsTable);
        resultsDao.insertResult(testResult);
        ((Window) this.getFocusCycleRootAncestor()).dispose();
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

    public void renderNextQuestion() {
        //clear input, etc




        this.repaint();
    }

}
