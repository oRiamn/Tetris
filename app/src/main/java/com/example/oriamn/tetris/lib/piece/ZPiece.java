package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.DeuxPosPiece;

/**
 * Created by oriamn on 10/06/17.
 */

public class ZPiece extends DeuxPosPiece {

    private static int[][] FORME = {
            {0, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
    };

    public ZPiece() {
        super(ZPiece.FORME);
    }
}
