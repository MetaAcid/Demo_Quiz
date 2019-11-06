package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;

import java.awt.*;
import ru.erixon.quizdemo.view.panels.QuizPanel;

public class QuizFrame extends BaseFrame{
    private Label lblTimer = new Label();
    private QuizPanel pnlQuiz = new QuizPanel();

    public QuizFrame(String title) throws HeadlessException {
        super(title);
        Timer timer = new Timer(this);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(lblTimer, BorderLayout.WEST);
        this.add(pnlQuiz, BorderLayout.CENTER);
    }

    private static class Timer implements Runnable {
        private QuizFrame frame;

        public Timer(QuizFrame frame) {
            this.frame = frame;
        }

        @Override
        public void run() {
            while (true) {
                String currentTime = String.valueOf(System.currentTimeMillis());//unix epoch
                frame.lblTimer.setText(currentTime);
                frame.repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
