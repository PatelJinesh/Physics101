package ui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 725747 on 1/5/2016.
 */
public class JToolBar extends javax.swing.JToolBar {
    public JToolBar(int orientation) {
        super("Edit", orientation);
    }

    @Override
    public void addSeparator() {
        JSeparator p = new JSeparator(SwingConstants.VERTICAL);
        p.setMaximumSize(new Dimension(1, 40));
        add(p);
    }
}
