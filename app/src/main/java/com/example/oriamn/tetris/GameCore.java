package com.example.oriamn.tetris;

import android.graphics.Color;
import android.os.Handler;
import android.util.Log;

import com.example.oriamn.tetris.piece.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by oriamn on 09/06/17.
 */

public class GameCore {

    private Piece piece;

    private GameActivity.MyAdapter gridAdapter;

    private ArrayList<Integer> blocks;

    private Handler myHandler;
    private Runnable horloge = new Runnable() {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique
            down();
            myHandler.postDelayed(this,500);
        }
    };




    public void createPiece() {

        this.piece = new IPiece();
        place();
    }


    public void place() {
        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();

        for(int i = 0; i < coordonnes.size(); i++) {
            gridAdapter.blocks.set(coordonnes.get(i), piece.getColor());
            blocks.set(coordonnes.get(i), 1);
            gridAdapter.notifyDataSetChanged();
        }
    }

    public boolean isPlacable() {
        boolean retour = true;
        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();
        int i = 0;
        while(retour && i < coordonnes.size()){
            int laCoordonnes = coordonnes.get(i);
            retour = blocks.size() > laCoordonnes && blocks.get(laCoordonnes) == 0;
            i++;
        }

        return retour;
    }

    public void right() {
        int rX = this.piece.getX();
        if(rX+piece.getWidth() < 10) {
            clear();
            this.piece.setX(rX+1);

            if(!isPlacable()) {
                this.piece.setX(rX-1);
            }
            place();
        }

    }

    public void rotate() {
        clear();
        this.piece.roate(false);

        if(!isPlacable()) {
            this.piece.roate(true);
        }

        place();
    }


    public void left() {
        int rX = this.piece.getX();
        if(rX >= 0) {
            clear();
            this.piece.setX(rX-1);

            if(!isPlacable()) {
                this.piece.setX(rX+1);
            }

            place();
        }
    }


    public void down() {
        clear();
        int cY = this.piece.getY();
        this.piece.setY(cY+1);

        if(!isPlacable()) {
            this.piece.setY(cY);
            place();
            createPiece();
        } else {
            place();
        }
    }

    public void clear() {
        ArrayList<Integer> coordonnes = this.piece.getCoordonnees();

        for(int i = 0; i < coordonnes.size(); i++) {
            gridAdapter.blocks.set(coordonnes.get(i), Color.BLACK);
            blocks.set(coordonnes.get(i), 0);
        }

        gridAdapter.notifyDataSetChanged();
    }

    public GameCore(GameActivity.MyAdapter gridAdapter, int numBlocks) {

        myHandler = new Handler();
        myHandler.postDelayed(horloge,500); // on redemande toute les 500ms

        this.gridAdapter = gridAdapter;

        blocks = new ArrayList<Integer>();
        for(int i = 0; i < numBlocks; i++) {
            this.blocks.add(0);
        }
        createPiece();
    }



    public void onPause() {
        if(myHandler != null)
            myHandler.removeCallbacks( horloge);
    }
}
