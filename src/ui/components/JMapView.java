package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Name:        Jinesh Patel
 * Date:        2015-12-01
 * File:        ui.components.JMapView.java
 * Description:
 */
public class JMapView extends JComponent implements MouseListener, MouseWheelListener, MouseMotionListener {
    private double translateX = 0;
    private double translateY = 0;

    private double zoom = 1;

    private int dragX = 0;
    private int dragY = 0;

    public JMapView() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
    //region Implemented

    @Override
    public void mousePressed(MouseEvent e) {
        this.dragX = e.getX();
        this.dragY = this.getHeight() - e.getY();

        this.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int currentX = e.getX();
        int currentY = getHeight() - e.getY();

        int deltax = currentX - dragX;
        int deltay = currentY - dragY;

        this.translateX += deltax;
        this.translateY -= deltay;

        this.dragX = currentX;
        this.dragY = currentY;

        this.repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getPreciseWheelRotation() != 1)
            zoom *= 1.20;
        else
            zoom *= 0.8;

        this.repaint();
    }

    //endregion

    //region Paint

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.paintComponent(((Graphics2D) g));
    }

    protected void paintComponent(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.translate(translateX, translateY + this.getHeight());
        g.scale(zoom, -zoom);
        g.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
    }

    //endregion

    //region Unimplemented

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    //endregion
}
