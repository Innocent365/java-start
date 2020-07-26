package 结构型.proxyPattern.virtualproxyWithStatusPattern;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NotReady implements Icon {

    IconMachine iconMachine;

    URL imgURL;

    public NotReady(IconMachine iconMachine) throws MalformedURLException {
        this.iconMachine = iconMachine;
        this.imgURL = new URL(iconMachine.getUrl());
    }

    Thread retrievalThread = null;

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
        if (retrievalThread == null) {
            //异步加载
            retrievalThread = new Thread(() -> {
                try {
                    ImageIcon imageIcon = new ImageIcon(imgURL, "CD cover");
                    //c.repaint();//头像准备好的时候，告诉swing要重绘
                    iconMachine.setImageIcon(imageIcon);
                    iconMachine.setState(iconMachine.getReady());
                    iconMachine.paintIcon(c, g, x, y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            retrievalThread.start();
        }
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }
}
