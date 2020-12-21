package org.dabhand.botz.graphics;

import java.awt.*;

/**
 * A grid is an MxN array of Tiles
 * It handles dirtyness and displaying
 */
public class Grid {
    private final Tiles tiles = new Tiles();
    private final int x,y,height,width,m,n;
    private final OneTile[][] grid;

    /** Create a new grid
     * @param x The base X co-ordinate
     * @param y The base Y co-ordinate
     * @param height The (total) height of the grid (this must be a multiple of n)
     * @param width The (total) width of the grid (this must be a multiple of m)
     * @param m The number of horizontal tiles
     * @param n The number of vertical tiles
     * @param background The tile to use for 'nothing'
     */
    public Grid(int x, int y, int height, int width, int m, int n, Tiles.Tile background) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.m = m;
        this.n = n;
        grid = new OneTile[n][];
        for ( int i = 0; i < n; i++ ) {
            grid[i] = new OneTile[m];
            for ( int j = 0; j < m; j++ ) {
                grid[i][j] = new OneTile(background,gridx(j),gridy(i),vsize(),hsize());
            }
        }
    }
    private int gridx(int hpos) {
        return x+hpos*hsize();
    }
    private int gridy(int vpos) {
        return x+vpos*vsize();
    }
    private int hsize() { return width / m; }
    private int vsize() { return height / n; }
    private class OneTile {
        private Tiles.Tile tile;
        private final int x,y,height,width;
        private boolean dirty = true;

        private OneTile(Tiles.Tile tile, int x, int y, int height, int width) {
            this.tile = tile;
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
        }
        public void set(Tiles.Tile t) {
            if ( tile != t ) {
                tile = t;
                dirty = true;
            }
        }
        public void display(Graphics g) {
            if ( dirty ) {
                g.drawImage(tiles.get(tile),x,y,width,height,null);
                //dirty = false;
            }
        }
    }
    public void setTile(int xpos, int ypos, Tiles.Tile t) {
        grid[ypos][xpos].set(t);
    }
    public void dirty(int xpos, int ypos) {
        grid[ypos][xpos].dirty = true;
    }
    public void display(Graphics g) {
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ )
                grid[j][i].display(g);
        }
    }
}
