package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.Piece;

/**
 * Piece de debug, pour les test
 *
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

    /**
     *
     * @param left
     */
    public void roate(boolean left) {
        // On desactive parce que la forme doit être une matrice carrée
        // super.roate(left);
    }
}
