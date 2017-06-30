package com.example.oriamn.tetris.lib.piece;

import com.example.oriamn.tetris.lib.DeuxPosPiece;

/**
 * Created by oriamn on 26/06/17.
 */

public class IPiece extends DeuxPosPiece {

    private static int[][] FORME = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public IPiece() {
        super(IPiece.FORME);
    }
}
