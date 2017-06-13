package com.example.oriamn.tetris.piece;

/**
 * Created by oriamn on 09/06/17.
 */

public class CubePiece extends Piece {

    private static int[][] FORME =  {
                                {1,1,1},
                                {1,1,1},
                                {1,1,1}
                            };

    public CubePiece() {
        super();
    }

    int[][] getForme() {
        return CubePiece.FORME;
    }
}
