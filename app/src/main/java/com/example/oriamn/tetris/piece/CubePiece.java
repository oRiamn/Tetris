package com.example.oriamn.tetris.piece;

/**
 * Created by oriamn on 09/06/17.
 */

public class CubePiece extends Piece {

    private static int[][] FORME =  {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,0}
    };

    public CubePiece() {
        super(CubePiece.FORME);
    }

}
