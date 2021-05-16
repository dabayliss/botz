package org.dabhand.botz.game;

import org.dabhand.botz.graphics.Tiles;
import org.dabhand.botz.graphics.WinScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


abstract public class Base {
    public final int frameWidth;
    public final int frameHeight;
    public final Tiles tiles = new Tiles();
    public JFrame frame;


    public Base(String title,int width,int height) {
        listResources();

        frameWidth = width;
        frameHeight = height;
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(frameWidth + 20, frameHeight + 40);

        Toolkit.getDefaultToolkit().setDynamicLayout(false);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public abstract void go();

    public Tiles getTiles() {
        return tiles;
    }

    private static void listResources() {
        URL dirURL = org.dabhand.botz.connect4.Connect4.class.getClassLoader().getResource("resources");
        System.out.println(dirURL.getProtocol());
        if (dirURL != null && dirURL.getProtocol().equals("file")) {
            String[] res = new String[0];
            try {
                res = new File(dirURL.toURI()).list();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < res.length; i++)
                System.out.println(res[i]);
        }
    }
}
