package ru.erixon.quizdemo.view.frames;

import java.awt.*;

public class GraphicsFrame extends Frame {

    public static void main(String[] args) {
        GraphicsFrame graphicsFrame =new GraphicsFrame();
        graphicsFrame.setSize(800,800);
        graphicsFrame.setVisible(true);
        graphicsFrame.repaint();
    }

    @Override
    public void paint(Graphics g) {
        int[] x1 = { 350, 350, 400, 400};
        int[] y1 = {350, 450, 450, 350};
        g.drawLine(50, 50, 50, 350);
        g.drawLine(50, 350, 350, 350);
        g.drawPolygon(x1, y1, 4);
    }
}
