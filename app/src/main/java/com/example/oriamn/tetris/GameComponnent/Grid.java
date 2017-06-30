package com.example.oriamn.tetris.GameComponnent;

import android.graphics.Color;

import com.example.oriamn.tetris.GameActivity;
import com.example.oriamn.tetris.GameCore;
import com.example.oriamn.tetris.piece.Piece;

import java.util.ArrayList;

/**
 * Created by oriamn on 30/06/17.
 */

public class Grid extends GameComponnent {

    private Piece piece;

    private ArrayList<Integer> blocks;

    private GameActivity.ViewAdapter gridAdapter;

    public Grid(GameCore core, Piece piece, ArrayList<Integer> blocks, GameActivity.ViewAdapter gridAdapter) {
        super(core);
        this.piece = piece;
        this.blocks = blocks;
        this.gridAdapter = gridAdapter;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void moveLigne(int fromY, int toY) {
        for (int i = 0; i < 10; i++){
            this.blocks.set(toY+i, this.blocks.get(fromY+i));
            this.gridAdapter.blocks.set(toY+i, this.gridAdapter.blocks.get(fromY+i));
        }
    }

    public void moveBlock(int fromY, int toY) {
        this.blocks.set(toY, this.blocks.get(fromY));
        this.gridAdapter.blocks.set(toY, this.gridAdapter.blocks.get(fromY));
    }

    public void fill(int x, int y) {
       this.fill(x+y*10);
    }

    public void fill(int i){
        gridAdapter.blocks.set(i, this.piece.getColor());
        blocks.set(i, 1);
    }

    public void empty(int x, int y) {
        this.empty(x+y*10);
    }

    public void empty(int i){
        gridAdapter.blocks.set(i, Color.BLACK);
        blocks.set(i, 0);
    }

    public void refresh(){
        gridAdapter.notifyDataSetChanged();
    }
}
