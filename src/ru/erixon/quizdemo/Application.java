package ru.erixon.quizdemo;

import ru.erixon.quizdemo.control.database.Connect;
import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.TimerFrame;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        MainFrame mainFrame = new MainFrame("your title here");
//        StudentFrame studentFrame = new StudentFrame(mainFrame,"Quiz");
//        TimerFrame timerFrame = new TimerFrame("TestTimer");

    }
}
