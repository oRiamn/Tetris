package com.example.oriamn.tetris.lib.componnent;

import android.graphics.Color;

import com.example.oriamn.tetris.GameActivity;
import com.example.oriamn.tetris.lib.GameCore;
import com.example.oriamn.tetris.lib.GameComponnent;
import com.example.oriamn.tetris.lib.Piece;

import java.util.ArrayList;

/**
 * La grille de jeu est composé de deux grilles :
 *  * la grille logique : qui va servir à évaluer les cases pleines
 *  * la grille visuelle : qui va afficher les cases (avec les couleurs et tout et tout)
 *
 * Created by oriamn on 30/06/17.
 */

public class Grid extends GameComponnent {

    private Piece piece;

    private ArrayList<Integer> logicGrid;

    private GameActivity.ViewAdapter visualGrid;

    public Grid(GameCore core, Piece piece, ArrayList<Integer> logicGrid, GameActivity.ViewAdapter visualGrid) {
        super(core);
        this.piece = piece;
        this.logicGrid = logicGrid;
        this.visualGrid = visualGrid;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Copie une ligne vers une autre
     * @param fromY Le numéro de la ligne à copier
     * @param toY Le numéro de la ligne à écraser
     * @see moveBlock
     */
    public void moveLigne(int fromY, int toY) {
        for (int i = 0; i < 10; i++){
            this.logicGrid.set(toY+i, this.logicGrid.get(fromY+i));
            this.visualGrid.blocks.set(toY+i, this.visualGrid.blocks.get(fromY+i));
        }
    }

    /**
     * Copie un block vers un autre
     * @param fromY Le numéro du block à copier
     * @param toY Le numéro du block à écraser
     */
    public void moveBlock(int fromY, int toY) {
        this.logicGrid.set(toY, this.logicGrid.get(fromY));
        this.visualGrid.blocks.set(toY, this.visualGrid.blocks.get(fromY));
    }

    /**
     * Remplit une case
     * @param x Ordonnée de la case
     * @param y Abscisse de la case
     */
    public void fill(int x, int y) {
       this.fill(x+y*10);
    }

    /**
     * Remplit une case
     * @param i Numéro de la case
     */
    public void fill(int i){
        visualGrid.blocks.set(i, this.piece.getColor());
        logicGrid.set(i, 1);
    }

    /**
     * Vide une case
     * @param x Ordonnée de la case
     * @param y Abscisse de la case
     */
    public void empty(int x, int y) {
        this.empty(x+y*10);
    }


    /**
     * Vide une case
     * @param i Numéro de la case
     */
    public void empty(int i){
        visualGrid.blocks.set(i, Color.BLACK);
        logicGrid.set(i, 0);
    }

    /**
     * Actualise la partie visuelle
     */
    public void refresh(){
        visualGrid.notifyDataSetChanged();
    }
}
