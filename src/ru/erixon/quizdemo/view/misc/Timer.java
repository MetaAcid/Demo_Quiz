package ru.erixon.quizdemo.view.misc;


public class Timer {
    private long start = System.currentTimeMillis();
    private long duration;

    public Timer(long seconds) {
        duration = seconds;
    }

    public String getTime() {
        return formatted(getRemaining());
    }

    public boolean isOver() {
        return getRemaining() == 0;
    }

    private long getRemaining() {
        long current = System.currentTimeMillis();
        return Math.max(duration - (current - start)/1000,0);
    }

    private String formatted(long seconds) {
        long min = seconds/60;
        long sec = seconds%60;
        return String.format("%d:%d", min, sec);
    }
}
