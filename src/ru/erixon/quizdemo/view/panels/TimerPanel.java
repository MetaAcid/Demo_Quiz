package ru.erixon.quizdemo.view.panels;

import ru.erixon.quizdemo.view.misc.Timer;

import java.awt.*;

public class TimerPanel extends Panel implements Runnable {
    private static final double MAGIC_CONST = Math.sqrt(3) / 2;

    private int hxEdge = 100; //hexagon edge length
    private Color hxColor = Color.GREEN;
    private Color tmColor = Color.RED;
    private Timer timer;
    private boolean stop = false;

    public TimerPanel(long seconds) {
        timer = new Timer(seconds);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(hxColor);
        g.fillPolygon(getHexagon());

        g.setColor(tmColor);
        g.setFont(getTimerFont());
//        g.drawString(time, hxEdge-25, hxEdge);
        drawCentered(g,timer.getTime());
    }

    private Polygon getHexagon() {
        Polygon hexagon = new Polygon();
        hexagon.addPoint((int) (MAGIC_CONST *hxEdge), 0);
        hexagon.addPoint(0, hxEdge/2);
        hexagon.addPoint(0,hxEdge*3/2);
        hexagon.addPoint((int) (MAGIC_CONST *hxEdge), hxEdge*2);
        hexagon.addPoint((int) (MAGIC_CONST *hxEdge*2), hxEdge*3/2);
        hexagon.addPoint((int) (MAGIC_CONST *hxEdge*2), hxEdge/2);
        return hexagon;
    }

    private Font getTimerFont() {
        return new Font("Arial", Font.BOLD, 40);
    }

    private void drawCentered(Graphics g, String s) {
        FontMetrics fm = g.getFontMetrics();
        int x = (int) (MAGIC_CONST*hxEdge) - fm.stringWidth(s)/2;
        int y = hxEdge + fm.getDescent();
        g.drawString(s,x,y);
    }

    @Override
    public void run() {
        while (this.isShowing() || !stop) {
            try {
                stop = true;
                System.out.println("!");
                Thread.sleep(990);
                this.repaint();
            } catch (InterruptedException ignore) {
            }
        }
    }
}
