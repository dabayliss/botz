package org.dabhand.botz.graphics;

import org.dabhand.botz.game.Base;

import javax.swing.*;
import java.awt.*;

/**
 * A score panel is really a text window which can be updated
 */
public class WinScreen extends JPanel {
    private final int x,y,height,width;
    private final Base parent;

    public WinScreen(int x, int y, int height, int width, Base parent) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.parent = parent;
        setSize(width,height);
        setBackground(Color.WHITE);
        setVisible(true);
    }

}
