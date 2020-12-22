package org.dabhand.botz.connect4;
import org.dabhand.botz.game.Base;
import org.dabhand.botz.graphics.Grid;
import org.dabhand.botz.graphics.Tiles;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class Connect4 extends Base {

    private Board board = new Board(this);

    public Connect4(String title) {
        super(title);
    }

    @Override
    public void go() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if ( board == null )
            System.out.println("Weird");
        else
            board.paint(g);
    }

    public static void main(String[] args) {
        Connect4 m = new Connect4("Connect 4");
        m.go();
    }

}
