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
    private boolean redTurn;
    private final Cursor redCursor,yellowCursor;

    public Board(Connect4 parent) {
        this.parent = parent;
        redCursor = parent.getTiles().getCursor(Tiles.Tile.RED_C4);
        yellowCursor = parent.getTiles().getCursor(Tiles.Tile.YELLOW_C4);
        grid = new Grid(0,0,Connect4.FrameHeight,Connect4.FrameWidth,7,6, Tiles.Tile.EMPTY_C4,parent);
        grid.callMe(new PingMe());
        setTurn(true);
    }
    public void paint(Graphics g) {
        grid.display(g);
    }
    private class PingMe implements Grid.GridListener {

        @Override
        public void clicked(int x, int y) {
            if ( isFull(x) )
                Toolkit.getDefaultToolkit().beep();
            else {
                add(redTurn, x);
                setTurn(!redTurn);
            }
        }
    }
    private void setTurn(boolean isRed) {
        redTurn = isRed;
        if ( redTurn )
            parent.setCursor(redCursor);
        else
            parent.setCursor(yellowCursor);
        parent.repaint();
    }

    private void add(boolean red,int pos) {
        for ( int y = 5; y >= 0; y-- ) {
            if ( grid.getTile(pos,y) == Tiles.Tile.EMPTY_C4) {
                grid.setTile(pos,y,red ? Tiles.Tile.RED_C4 : Tiles.Tile.YELLOW_C4);
                parent.repaint();
                return;
            }
        }
    }
    private boolean isFull(int x) {
        return grid.getTile(x,0) != Tiles.Tile.EMPTY_C4;
    }
}
