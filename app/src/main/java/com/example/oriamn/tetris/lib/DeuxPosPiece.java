package com.example.oriamn.tetris.lib;

/**
 * Created by oriamn on 27/06/17.
 */

public abstract class DeuxPosPiece extends Piece {

    public DeuxPosPiece(int[][] forme) {
        super(forme);
    }

    private boolean sens = false;

    public void roate(boolean left) {
        this.sens = !this.sens;
        super.roate(this.sens);
    }
}
