package com.example.oriamn.tetris.piece;

/**
 * Created by oriamn on 27/06/17.
 */

public class JPiece extends Piece {

    private static int[][] FORME = {
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
    };

    public JPiece() {
        super(JPiece.FORME);
    }
}
