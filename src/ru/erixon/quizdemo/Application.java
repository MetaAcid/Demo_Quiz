package ru.erixon.quizdemo;

import ru.erixon.quizdemo.controller.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;

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

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Main Menu");
    }
}
