package ru.erixon.quizdemo;

import ru.erixon.quizdemo.view.frames.MainFrame;
import ru.erixon.quizdemo.view.frames.QuizFrame;
import ru.erixon.quizdemo.view.frames.TimerFrame;
import ru.erixon.quizdemo.view.frames.StudentFrame;

public class Application {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("your title here");
        StudentFrame studentFrame = new StudentFrame(mainFrame,"Quiz");
        //TimerFrame timerFrame = new TimerFrame("TestTimer");
        QuizFrame quizFrame = new QuizFrame("Quiz");
    }
}
