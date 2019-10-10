package proxyPattern.virtualproxyWithStatusPattern;

import javax.swing.*;
import java.awt.*;

public class Ready implements Icon {

    IconMachine iconMachine;

    public Ready(IconMachine iconMachine) {
        this.iconMachine = iconMachine;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        iconMachine.getImageIcon().paintIcon(c, g, x, y);
        c.repaint();
    }

    @Override
    public int getIconWidth() {
        return iconMachine.getImageIcon().getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return iconMachine.getImageIcon().getIconHeight();
    }
}
