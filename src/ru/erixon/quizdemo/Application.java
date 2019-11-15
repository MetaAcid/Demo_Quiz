package ru.erixon.quizdemo;

import ru.erixon.quizdemo.controller.Config;
import ru.erixon.quizdemo.controller.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;
import ru.erixon.quizdemo.view.frames.StudentFrame;
import ru.erixon.quizdemo.view.frames.TeacherFrame;

public class Application {
    public final static PostgresConnectionManager manager = new PostgresConnectionManager("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
    public final static Config config = new Config();

    public static void main(String[] args) {
//          MainFrame mainFrame = new MainFrame("Main Menu");
        QuizFrame quizFrame = new QuizFrame("Quiz");
//        TeacherFrame teacherFrame = new TeacherFrame("Teacher");
        // StudentFrame studentFrame = new StudentFrame(null, "kfdjsfklsdf");
    }
}
