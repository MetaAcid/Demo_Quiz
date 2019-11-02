package ru.erixon.quizdemo.view.frames;

import ru.artimenko.quizdemo.BaseFrame;

import java.awt.*;

public class TimerFrame extends BaseFrame {
    private Label label = new Label();

    public TimerFrame(String title) throws HeadlessException {
        super(title);
        Timer timer = new Timer(this);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        this.setSize(700,700);
        this.add(label);
        this.setVisible(true);

    }

    private static class Timer implements Runnable {
        private TimerFrame frame;

        public Timer(TimerFrame frame) {
            this.frame = frame;
        }

        @Override
        public void run() {
            while (true) {
                String currentTime = String.valueOf(System.currentTimeMillis());//unix epoch
                frame.label.setText(currentTime);
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
