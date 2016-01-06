package ui.styling.borders;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-02
 * File:        TextFieldBorder.java
 * Description:
 */
public class TextFieldBorder implements Border {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY);
        g.drawRect(x, y, width - 1, height - 1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(3, 3, 3, 3);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
