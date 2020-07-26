package 结构型.proxyPattern.virtualproxyWithStatusPattern;


import 结构型.proxyPattern.virtualproxy.ImageComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.Hashtable;

public class IconMachineTestDriver {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable cds = new Hashtable();

    public IconMachineTestDriver() throws Exception {
        cds.put("Ambient: Music for Airports", "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2", "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
        cds.put("oliver", "http://www.cs.yale.edu/homes/freeman-elisabeth/2004/9/Oliver_sm.jpg");

//        URL initialURL = new URL((String)(cds.get("Selected Ambient Works, Vol. 2")));
        String initialURL = (String) cds.get("Selected Ambient Works, Vol. 2");
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (Enumeration e = cds.keys(); e.hasMoreElements(); ) {
            String name = (String) e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener((ActionEvent e1) -> {
                String itemName = e1.getActionCommand();
                String itemUrl = (String) cds.get(itemName);
                imageComponent.setIcon(new IconMachine(itemUrl));
                frame.repaint();
            });
        }

        //建立框架和菜单
        Icon icon = new IconMachine(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }


    public static void main(String[] args) throws Exception {
        IconMachineTestDriver iconMachine = new IconMachineTestDriver();
    }
}
