package org.dabhand.botz.connect4;

import org.dabhand.botz.game.Base;
import org.dabhand.botz.graphics.Grid;

import java.awt.event.WindowEvent;

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
        //This is an early demo of a victory system.
        //if(total >= 100){
        //    System.out.println("Red Wins!");
       // }
       // else if(total<=-100){
       //     System.out.println("Yellow Wins!");
      //  }
      //  else
      //      System.out.println();
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
        //Victory system
        if(num == 4 && isRed)
        {
            System.exit(0);
        }
        else if(num == 4)
        {
            System.exit(0);
        }
        //ends
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
