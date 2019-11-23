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
        int[] x = {0,100,500};
        int[] y = {0,50,400};
        g.drawPolygon(x, y, 3);
    }
}
