package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.Piece;

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
