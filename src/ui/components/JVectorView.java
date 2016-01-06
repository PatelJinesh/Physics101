package ui.components;

import events.listeners.VectorChangedListener;
import structures.DrawnVector;
import ui.styling.strokes.AddedVectorStroke;
import ui.styling.strokes.SubtractedVectorStroke;
import utils.VectorUtils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-01
 * File:        ui.components.JVectorView.java
 * Description:
 */
public class JVectorView extends JMapView implements VectorChangedListener {
    private final ArrayList<DrawnVector> vectors;

    @Override
    public void vectorChanged() {
        this.repaint();
    }

    public JVectorView() {
        this.vectors = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics2D g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawOval(-10, -10, 20, 20);
        g.fillOval(-1, -1, 2, 2);

        for (DrawnVector vector : vectors)
            this.drawVector(g, vector);
    }

    public void attachVector(DrawnVector vector) {
        if (!vectors.isEmpty()) {
            vector.setStartX(vectors.get(vectors.size() - 1).getEndX());
            vector.setStartY(vectors.get(vectors.size() - 1).getEndY());
        }

        vector.addVectorChangedListener(this);

        this.vectors.add(vector);

        this.repaint();
    }

    public DrawnVector getVector(int index) {
        return vectors.get(index);
    }

    public void swapVectors(int vectorIndexA, int vectorIndexB) {
        DrawnVector vector = vectors.get(vectorIndexA);
        this.vectors.set(vectorIndexA, vectors.get(vectorIndexB));
        this.vectors.set(vectorIndexB, vector);

        this.reconnectVectors(1);
    }

    public void removeVector(int index) {
        this.vectors.remove(index);

        this.reconnectVectors(1);
    }

    public void editVector(int index, DrawnVector newVector) {
        vectors.set(index, newVector);

        this.reconnectVectors(1);
    }

    private void reconnectVectors(int index) {
        if (vectors.size() >= 1) {
            vectors.get(0).setStartX(0);
            vectors.get(0).setStartY(0);
        }

        for (int i = index; i < vectors.size(); i++) {
            vectors.get(i).setStartX(vectors.get(i - 1).getEndX());
            vectors.get(i).setStartY(vectors.get(i - 1).getEndY());
        }

        this.repaint();
    }

    private void drawVector(Graphics2D g, DrawnVector vector) {
        g.setColor(vector.getColor());

        g.setStroke(vector.getMode() == DrawnVector.VectorMode.SUBTRACT
                        ? new SubtractedVectorStroke()
                        : new AddedVectorStroke());

        g.drawLine(vector.getStartX(), vector.getStartY(), vector.getEndX(), vector.getEndY());

        this.drawArrowTip(g, vector.getEndX(), vector.getEndY(), vector.getMode() == DrawnVector.VectorMode.SUBTRACT
                ? vector.getAngle() - 180
                : vector.getAngle());
    }

    private void drawArrowTip(Graphics2D g, int x, int y, double angle) {
        g.rotate(Math.toRadians(angle), x, y);

        Polygon p = new Polygon();

        int leftx = ((int) (x + VectorUtils.getXComponent(20, 145)));
        int lefty = ((int) (y + VectorUtils.getYComponent(20, 145)));

        int rightx = ((int) (x + VectorUtils.getXComponent(20, 215)));
        int righty = ((int) (y + VectorUtils.getYComponent(20, 215)));

        p.addPoint(x, y);
        p.addPoint(leftx, lefty);
        p.addPoint(rightx, righty);

        g.fillPolygon(p);

        g.rotate(Math.toRadians(-angle), x, y);
    }
}
