package com.example.oriamn.tetris.piece;

/**
 * Created by oriamn on 10/06/17.
 */

public class ZPiece extends Piece {
    private static int[][] FORME =  {
            {0,1,1},
            {1,1,0}
    };

    public ZPiece() {
        super();
    }

    int[][] getForme() {
        return ZPiece.FORME;
    }
}
