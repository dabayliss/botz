package org.dabhand.botz.connect4;

import org.dabhand.botz.game.Base;
import org.dabhand.botz.graphics.Grid;
import org.dabhand.botz.graphics.ScoreTable;
import org.dabhand.botz.graphics.Tiles;

import java.awt.*;
import java.sql.SQLOutput;

/**
 * The base from which scorers will be built
 */
abstract public class BaseScorer extends ScoreTable {
    private final Grid grid;

    public BaseScorer(int x, int y, int height, int width, Base parent, Grid grid) {
        super(x,y,height,width,parent);
        this.grid = grid;
    }

    abstract public int getScore();
    protected void doHorizontalFours() {
        for ( int i = 0; i < 6; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                Boolean red[] = new Boolean[4];
                for ( int k = 0; k < 4; k++ ) {
                    switch (grid.getTile(j + k, i)) {
                        case EMPTY_C4: break;
                        case RED_C4: red[k] = true; break;
                        case YELLOW_C4: red[k] = false; break;
                    }
                }
                takeHorizontal(red);
            }
        }
    }
    protected void doVerticalFours() {
        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 7; j++ ) {
                Boolean red[] = new Boolean[4];
                for ( int k = 0; k < 4; k++ ) {
                    switch (grid.getTile(j, i+k)) {
                        case EMPTY_C4: break;
                        case RED_C4: red[k] = true; break;
                        case YELLOW_C4: red[k] = false; break;
                    }
                }
                takeVertical(red);
            }
        }
    }
    protected void doDiagonalFalling(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++){
                Boolean red[] = new Boolean[4];
                for(int k = 0; k < 4; k++){
                    switch (grid.getTile((j+k),(i+k))){
                        case EMPTY_C4:break;
                        case RED_C4: red[k]= true; break;
                        case YELLOW_C4: red[k]=false;break;
                    }
                }
                takeDiagonalFalling(red);
            }
        }
    }
    protected void doDiagonalRising(){
        for(int i = 4; i < 6; i++) {
            for(int j = 0; j < 4; j++){
                Boolean red[] = new Boolean[4];
                for(int k = 0; k < 4; k++){
                    switch (grid.getTile((j+k),(i-k))){
                        case EMPTY_C4:break;
                        case RED_C4: red[k]= true; break;
                        case YELLOW_C4: red[k]=false;break;
                    }
                }
                takeDiagonalRising(red);
            }
        }
    }


    abstract protected void takeHorizontal(Boolean[] tiles);
    abstract protected void takeVertical(Boolean[] tiles);
    abstract protected void takeDiagonalFalling(Boolean[] tiles);
    abstract protected void takeDiagonalRising(Boolean[] tiles);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int score = getScore();
        g.drawString("Score "+score,20,20);
    }
}
