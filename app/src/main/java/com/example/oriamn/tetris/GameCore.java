package com.example.oriamn.tetris;

import android.app.AlertDialog;
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

    private AlertDialog eofGame;

    private ArrayList<Integer> blocks;

    private boolean shouldIDoIt = true;
    private Handler myHandler;
    private Runnable horloge = new Runnable() {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique
            down();
            if(shouldIDoIt){
                myHandler.postDelayed(this,500);
            } else {
                myHandler.removeCallbacks(this);
            }
        }
    };

    public void createPiece() {

        int maximum = 7;
        int minimum = 1;

        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int randomNum = minimum + i;

        switch (randomNum) {
            case 1 :
                this.piece = new CubePiece();
                break;
            case 2 :
                this.piece = new IPiece();
                break;
            case 3 :
                this.piece = new SPiece();
                break;
            case 4 :
                this.piece = new ZPiece();
                break;
            case 5 :
                this.piece = new JPiece();
                break;
            case 6 :
                this.piece = new LPiece();
                break;
            default:
                this.piece = new TPiece();
        }

        this.piece.setPosition(2,0);

        if(isPlacable()) {
            place();
        } else {
            shouldIDoIt = false;
            this.eofGame.show();
        }
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
        if(rX+piece.getWidth() < 9) {
            clear();
            this.piece.setX(rX+1);

            if(!isPlacable()) {
                this.piece.setX(rX-1);
            }
            place();
        }

    }

    public void rotate(boolean sens) {
        clear();
        this.piece.roate(sens);
        if(!isPlacable()) {
            this.piece.roate(!sens);
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

    public GameCore(GameActivity.MyAdapter gridAdapter, int numBlocks, AlertDialog eofGame) {

        this.eofGame = eofGame;

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
