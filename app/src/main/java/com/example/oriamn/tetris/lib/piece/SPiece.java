package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.DeuxPosPiece;

/**
 * Created by oriamn on 26/06/17.
 */

public class SPiece extends DeuxPosPiece {

    private static int[][] FORME = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {0, 0, 0, 0}
    };

    public SPiece() {
        super(SPiece.FORME);
    }
}
