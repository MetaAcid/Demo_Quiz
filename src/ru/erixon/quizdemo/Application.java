package ru.erixon.quizdemo;

import ru.erixon.quizdemo.control.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.StudentFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;
import ru.erixon.quizdemo.view.frames.TeacherFrame;

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
        //QuizFrame quizFrame = new QuizFrame("Quiz");
        //TeacherFrame teacherFrame = new TeacherFrame("Teacher");
    }
}
