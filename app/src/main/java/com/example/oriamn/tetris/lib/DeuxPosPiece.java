package com.example.oriamn.tetris.lib;

/**
 * Piece dont la rotation se résume à 2 positions
 *
 * Created by oriamn on 27/06/17.
 */

public abstract class DeuxPosPiece extends Piece {

    public DeuxPosPiece(int[][] forme) {
        super(forme);
    }

    /**
     * Sens dans lequel se trouve la piece
     */
    private boolean sens = false;

    /**
     * Force le changement de sens en alternance
     *
     * La piece ne fait que tourner dans un sens puis dans l'autre
     * pour garantir que la piece ne prenne que deux position
     *
     * @param left
     */
    public void roate(boolean left) {
        this.sens = !this.sens;
        super.roate(this.sens);
    }
}
