package com.example.oriamn.tetris.lib;

import android.app.AlertDialog;

import com.example.oriamn.tetris.GameActivity;
import com.example.oriamn.tetris.lib.Piece;
import com.example.oriamn.tetris.lib.componnent.Grid;
import com.example.oriamn.tetris.lib.componnent.ControlBox;
import com.example.oriamn.tetris.utils.Rand;
import com.example.oriamn.tetris.lib.componnent.Timer;

import java.util.ArrayList;

/**
 * Created by oriamn on 09/06/17.
 */

public class GameCore {

    private Timer timer;

    private ControlBox controlBox;

    private Piece piece;

    private Grid grid;

    private AlertDialog eofGame;

    private ArrayList<Integer> blocks;

    public void newPiece() {

        this.piece = Rand.getPiece();
        this.piece.setPosition(2,0);

        this.controlBox.setPiece(this.piece);
        this.grid.setPiece(this.piece);

        if(this.controlBox.isPlacable()) {
            removeLignesPleines();
            place();
        } else {
            this.timer.setShouldIDoIt(false);
            this.eofGame.show();
        }
    }

    public void place() {
        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();
        for(int i = 0; i < coordonnes.size(); i++) {
           this.grid.fill(coordonnes.get(i));
        }
        this.grid.refresh();
    }

    public void removeLignesPleines(){
        ArrayList<Integer> lignesPleines = this.getLignesPleine();
        if(lignesPleines.size() >0) {
            int derniereCase = 0;
            while (lignesPleines.size() > 0) {
                derniereCase = lignesPleines.get(0);

                // du bas de la grille jusq'en haut
                for (int i = derniereCase; i >= 10; i--) {
                    // on décale chaque block d'une ligne
                    this.grid.moveBlock(i-10, i);
                }
                lignesPleines.remove(0);
            }

            this.grid.refresh();
        }
    }

    private ArrayList<Integer> getLignesPleine(){
        boolean isPleine=false;
        ArrayList<Integer> lignesPleines= new ArrayList<Integer>();

        for (int i = 9; i < blocks.size(); i+=10) {
            isPleine=true;
            for(int j = 0; j < 10; j++) {
                if(blocks.get(i-j) == 0){
                    isPleine=false;
                }
            }
            if(isPleine){
                lignesPleines.add(i);
            }
        }

        return lignesPleines;
    }

    public void clear() {
        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();
        for(int i = 0; i < coordonnes.size(); i++) {
            this.grid.empty(coordonnes.get(i));
        }
        this.grid.refresh();
    }

    public GameCore(GameActivity.ViewAdapter gridAdapter, int numBlocks, AlertDialog eofGame) {

        this.eofGame = eofGame;

        blocks = new ArrayList<Integer>();
        for(int i = 0; i < numBlocks; i++) {
            this.blocks.add(0);
        }

        this.piece = Rand.getPiece();
        this.piece.setPosition(2,0);
        

        this.controlBox = new ControlBox(this,this.piece, this.blocks);
        this.grid = new Grid(this, this.piece, this.blocks, gridAdapter);

        this.timer = new Timer(this, 500, new Runnable() {
            @Override
            public void run() {
                controlBox.down();
            }
        });
    }

    public ControlBox getControlBox() {
        return controlBox;
    }

    public void onPause() {
       this.timer.setShouldIDoIt(false);
    }
}
