package ru.erixon.quizdemo;

import ru.erixon.quizdemo.controller.Config;
import ru.erixon.quizdemo.controller.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;

public class Application {
    public final static PostgresConnectionManager manager = new PostgresConnectionManager("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
    public final static Config config = new Config();

    public static void main(String[] args) {
          MainFrame mainFrame = new MainFrame("Main Menu");
    }
}
