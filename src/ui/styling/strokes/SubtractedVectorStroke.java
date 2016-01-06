package ui.styling.strokes;

import java.awt.*;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-02
 * File:        SubtractedVectorStroke.java
 * Description: Stroke for the displaying of a subtraction vector on the screen.
 */
public class SubtractedVectorStroke extends BasicStroke {
    /**
     * Constructor for the stroke.
     */
    public SubtractedVectorStroke() {
        super(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, new float[]{10.0f}, 0.0f);
    }
}
