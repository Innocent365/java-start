package 结构型.proxyPattern.virtualproxyWithStatusPattern;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class IconMachine implements Icon {

    private String url;
    private Icon imageIcon;

    private Ready ready;
    private NotReady notReady;
    private Icon state;


    public IconMachine(String url) {
        this.url = url;
        this.ready = new Ready(this);
        try {
            this.notReady = new NotReady(this);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        state = notReady;
    }


    public Ready getReady() {
        return ready;
    }

    public NotReady getNotReady() {
        return notReady;
    }

    public String getUrl() {
        return url;
    }

    public Icon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(Icon imageIcon) {
        this.imageIcon = imageIcon;

    }

    public void setState(Icon ready) {
        this.state = ready;
    }

    public Icon getState() {
        return state;
    }


    public void paintIcon(Component c, Graphics g, int x, int y) {
        state.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return state.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return state.getIconHeight();
    }
}
