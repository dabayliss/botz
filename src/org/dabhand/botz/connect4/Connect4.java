package org.dabhand.botz.connect4;
import org.dabhand.botz.game.Base;
import org.dabhand.botz.graphics.ScoreTable;

import javax.swing.*;
import java.awt.*;

public class Connect4 extends Base {

    private Board board = new Board(this,boardHeight,boardWidth);
    private ScoreTable scoreTable = new UniformWeighted(boardWidth,0,boardHeight, scoreWidth,this, board.grid);
    static int boardWidth = 700;
    static int boardHeight = 600;
    static private int scoreWidth = 300;

    public Connect4(String title) {
        super(title,boardWidth+scoreWidth,boardHeight);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.LINE_AXIS));
        frame.add(board);
        frame.add(scoreTable);
        frame.setVisible(true);
    }

    @Override
    public void go() {

    }

    public static void main(String[] args) {
        Connect4 m = new Connect4("Connect 4");
        m.go();
    }

}
