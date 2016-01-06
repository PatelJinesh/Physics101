package ui.styling.borders;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Jinesh Patel on 2016-01-05.
 */
public class ColumnHeaderBorder implements Border {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawLine(0, height - 1, width, height - 1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
