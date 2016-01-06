package ui.styling.borders;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Name:        Jinesh Patel
 * Date:        2016-01-02
 * File:        ButtonBorder.java
 * Description:
 */
public class ButtonBorder implements Border {

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width - 1, height - 1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(4, 25, 4, 25);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
