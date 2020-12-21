package org.dabhand.botz.connect4;

import org.dabhand.botz.graphics.Grid;
import org.dabhand.botz.graphics.Tiles;

import java.awt.*;

/**
 * A Connect 4 board
 */
public class Board {
    final Grid grid;
    private final Connect4 parent;

    public Board(Connect4 parent) {
        this.parent = parent;
        grid = new Grid(0,0,Connect4.FrameHeight,Connect4.FrameWidth,7,6, Tiles.Tile.EMPTY_C4,parent);
        grid.callMe(new PingMe());
    }
    public void paint(Graphics g) {
        grid.display(g);
    }
    private class PingMe implements Grid.GridListener {

        @Override
        public void clicked(int x, int y) {
            if ( isFull(x) )
                Toolkit.getDefaultToolkit().beep();
            else
                System.out.println("Clicked "+x);
        }
    }

    private boolean isFull(int x) {
        return grid.getTile(x,5) != Tiles.Tile.EMPTY_C4;
    }
}
