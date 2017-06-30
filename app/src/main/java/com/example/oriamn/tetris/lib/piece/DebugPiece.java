package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.Piece;

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
