package com.example.oriamn.tetris.GameComponnent;

import android.util.Log;

import com.example.oriamn.tetris.GameCore;
import com.example.oriamn.tetris.piece.Piece;

import java.util.ArrayList;

/**
 * Created by oriamn on 29/06/17.
 */

public class ControlBox extends  GameComponnent {

    private Piece piece;

    private ArrayList<Integer> blocks;

    public ControlBox(GameCore core, Piece piece, ArrayList<Integer> blocks) {
        super(core);
        this.piece = piece;
        this.blocks = blocks;
    }

    public boolean isPlacable() {
        boolean retour = true;

        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();
        int i = 0;
        while (retour && i < coordonnes.size()) {
            int laCoordonnes = coordonnes.get(i);

            retour = this.blocks.size() > laCoordonnes && this.blocks.get(laCoordonnes) == 0;
            i++;
        }

        return retour;
    }

    public void right() {
        int rX = this.piece.getX();
        if(rX+piece.getWidth() < 9) {
            this.core.clear();
            this.piece.setX(rX+1);

            if(!isPlacable()) {
                this.piece.setX(rX-1);
            }

            this.core.place();
        }

    }

    public void rotate(boolean sens) {
        this.core.clear();
        this.piece.roate(sens);
        if(!isPlacable()) {
            this.piece.roate(!sens);
        }
        this.core.place();
    }

    public void left() {
        int rX = this.piece.getX();
        if(rX >= 0) {
            this.core.clear();
            this.piece.setX(rX-1);

            if(!isPlacable()) {
                this.piece.setX(rX+1);
            }

            this.core.place();
        }
    }

    public void down() {
        this.core.clear();
        int cY = this.piece.getY();
        this.piece.setY(cY+1);

        if(!isPlacable()) {
            this.piece.setY(cY);
            this.core.place();
            this.core.newPiece();
        } else {
            this.core.place();
        }
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
