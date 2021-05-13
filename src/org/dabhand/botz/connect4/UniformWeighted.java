package org.dabhand.botz.connect4;

import org.dabhand.botz.game.Base;
import org.dabhand.botz.graphics.Grid;

/**
 * Simply score each line equally
 * Red is positive, yellow negative
 */
public class UniformWeighted extends BaseScorer {
    int total;

    public UniformWeighted(int x, int y, int height, int width, Base parent, Grid grid) {
        super(x,y,height,width,parent,grid);
    }

    @Override
    public int getScore() {
        total = 0;
        doHorizontalFours();
        doVerticalFours();
        doDiagonalFalling();
        doDiagonalRising();
        return total;
    }
    private void doLine(Boolean[] tiles) {
        Boolean isRed = null;
        int num = 0;
        for ( int i = 0; i < 4; i++ ) {
            if ( tiles[i] != null ) {
                if ( isRed == null ) {
                    isRed = tiles[i];
                } else if ( isRed != tiles[i] )
                    return;
                num++;
            }
        }
        if ( isRed != null ) {
            if ( isRed )
                total += scaledWeight(num);
            else
                total -= scaledWeight(num);
        }
    }
    private int scaledWeight(int n) {
        switch (n) {
            case 1: return 1;
            case 2: return 4;
            case 3: return 9;
            case 4: return 100;
            default: return 0;
        }
    }

    @Override
    protected void takeHorizontal(Boolean[] tiles) {
        doLine(tiles);
    }

    @Override
    protected void takeVertical(Boolean[] tiles) {
        doLine(tiles);
    }

    @Override
    protected void takeDiagonalFalling(Boolean[] tiles) {
        doLine(tiles);
    }

    @Override
    protected void takeDiagonalRising(Boolean[] tiles) {
        doLine(tiles);
    }
}
