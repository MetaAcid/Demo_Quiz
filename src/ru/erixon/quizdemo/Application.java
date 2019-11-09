package ru.erixon.quizdemo;

import ru.artimenko.quizdemo.BaseFrame;
import ru.erixon.quizdemo.controller.database.PostgresConnectionManager;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.panels.TimerPanel;

import java.awt.*;
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
//        MainFrame mainFrame = new MainFrame("Main Menu");
        Frame frame = new BaseFrame("test") {};
        frame.add(new TimerPanel(100));
        frame.setSize(800,600);
//        frame.setResizable(false);

        frame.setVisible(true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (String availableFontFamilyName : ge.getAvailableFontFamilyNames()) {
            System.out.println(availableFontFamilyName);
        }
    }
}
