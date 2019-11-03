package ru.erixon.quizdemo;

import ru.erixon.quizdemo.control.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static PostgresConnectionManager manager;

    static {
        try {
            manager = new PostgresConnectionManager("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {


        MainFrame mainFrame = new MainFrame("your title here");
//        StudentFrame studentFrame = new StudentFrame(mainFrame,"Quiz");
//TimerFrame timerFrame = new TimerFrame("TestTimer");
//        QuizFrame quizFrame = new QuizFrame("Quiz");
    }
}
