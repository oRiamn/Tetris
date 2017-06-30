package com.example.oriamn.tetris.lib.componnent;

import com.example.oriamn.tetris.lib.GameComponnent;
import com.example.oriamn.tetris.lib.GameCore;
import com.example.oriamn.tetris.lib.Piece;

import java.util.ArrayList;

/**
 * La controlBox fonctionne comme une manette console de jeux vidéos
 *
 * Elle va servir d'interface entre la vue (les boutons)
 * et le controlleur du jeu
 *
 * Created by oriamn on 29/06/17.
 */

public class ControlBox extends GameComponnent {

    private Piece piece;

    private ArrayList<Integer> blocks;

    public ControlBox(GameCore core, Piece piece, ArrayList<Integer> blocks) {
        super(core);
        this.piece = piece;
        this.blocks = blocks;
    }

    /**
     * Vérifie si la piece, tel qu'elle est positionnée n'entre pas en colision
     * @return Vrai s'il n'y a aucune collision
     */
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

    /**
     * Déplace la piece de 1 case vers la droite si cela ne créé pas de collision
     */
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

    /**
     * Déplace la piece de 1 case vers la gauche si cela ne créé pas de collision
     */
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

    /**
     * Effectue une rotation de la piece si cela ne créé pas de collision
     * @param sens Si vrai la rotation sera dans le sens horaire
     */
    public void rotate(boolean sens) {
        this.core.clear();
        this.piece.roate(sens);
        if(!isPlacable()) {
            this.piece.roate(!sens);
        }
        this.core.place();
    }

    /**
     * Fais tomber la piece d'une case si cela ne créé pas de collision
     * Si cela créé un collision, l'action va créer une nouvelle piece
     * @see GameCore.newPiece
     */
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