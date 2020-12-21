package org.dabhand.botz;
import com.relx.rba.tardis.runtime.dataset.GenericRecordMeta;
import org.dabhand.botz.graphics.Grid;
import org.dabhand.botz.graphics.Tiles;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;

public class Main extends Canvas {

    static final int FrameWidth = 700;
    static final int FrameHeight = 600;
    private final Grid grid = new Grid(0,0,FrameHeight,FrameWidth,7,6, Tiles.Tile.EMPTY_C4);
    public void paint(Graphics g) {
        grid.display(g);
    }

    public static void main(String[] args) throws URISyntaxException {
        Main m = new Main();
        URL dirURL = m.getClass().getClassLoader().getResource("resources");
        System.out.println(dirURL.getProtocol());
        if (dirURL != null && dirURL.getProtocol().equals("file")) {
            String[] res = new File(dirURL.toURI()).list();
            for ( int i = 0; i < res.length; i++ )
                System.out.println(res[i]);
        }
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(FrameWidth+40, FrameHeight+40);
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
