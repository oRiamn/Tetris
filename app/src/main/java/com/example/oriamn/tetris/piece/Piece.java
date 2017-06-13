package com.example.oriamn.tetris.piece;

import android.graphics.Color;

/**
 * Created by oriamn on 09/06/17.
 */

public abstract class Piece {

    private int color;

    public Piece() {
        this.color = Color.RED;
    }


    abstract int[][] getForme();
}
