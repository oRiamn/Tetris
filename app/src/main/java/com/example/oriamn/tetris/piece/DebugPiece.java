package com.example.oriamn.tetris.piece;

/**
 * Created by oriamn on 28/06/17.
 */

public class DebugPiece extends Piece {

    private static int[][] FORME = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
    };

    public DebugPiece() {
        super(DebugPiece.FORME);
    }

    public void roate(boolean left) {

    }
}
