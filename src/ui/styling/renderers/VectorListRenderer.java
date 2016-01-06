package ui.styling.renderers;

import structures.DrawnVector;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jinesh Patel on 2016-01-05.
 */
public class VectorListRenderer extends JLabel implements ListCellRenderer<DrawnVector> {
    public VectorListRenderer() {
        this.setOpaque(true);
        this.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends DrawnVector> list, DrawnVector value, int index, boolean isSelected, boolean cellHasFocus) {
        this.setForeground(value.getColor());
        this.setText(value.getName());

        if (index % 2 == 0)
            this.setBackground(new Color(225, 225, 225));
        else
            this.setBackground(Color.WHITE);

        if (isSelected)
            this.setBackground(new Color(77, 230, 255));

        return this;
    }
}
