package org.dabhand.botz.connect4;
import org.dabhand.botz.graphics.Grid;
import org.dabhand.botz.graphics.Tiles;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class Connect4 extends JPanel {

    static final int FrameWidth = 700;
    static final int FrameHeight = 600;
    private Board board = new Board(this);
    private static void listResources() {
        URL dirURL = Connect4.class.getClassLoader().getResource("resources");
        System.out.println(dirURL.getProtocol());
        if (dirURL != null && dirURL.getProtocol().equals("file")) {
            String[] res = new String[0];
            try {
                res = new File(dirURL.toURI()).list();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            for ( int i = 0; i < res.length; i++ )
                System.out.println(res[i]);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.paint(g);
    }

    public static void main(String[] args) {
        Connect4 m = new Connect4();
        listResources();
        JFrame f = new JFrame();
        f.setTitle("Connect 4");
        f.add(m);
        f.setSize(FrameWidth+20, FrameHeight+40);
        Toolkit.getDefaultToolkit().setDynamicLayout(false);
        //f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(new WindowListener() {
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

}
