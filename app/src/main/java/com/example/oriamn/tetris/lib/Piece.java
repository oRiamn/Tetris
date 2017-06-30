package com.example.oriamn.tetris.lib;

import com.example.oriamn.tetris.utils.Rand;
import com.example.oriamn.tetris.utils.Matrix;

import java.util.ArrayList;

/**
 * Created by oriamn on 09/06/17.
 */

public abstract class Piece {

    private int color;

    private int[][] forme;

    private int width,height;

    private ArrayList<Integer> coordonnees;

    private int x, y;


    protected Piece(int[][] forme) {
        this.forme = forme;
        this.color = Rand.getColor();
        this.coordonnees = new ArrayList<Integer>();
        this.computeCoordonnees();
    }

    private void computeCoordonnees() {
        this.coordonnees = new ArrayList<Integer>();
        int x, y;
        this.height=0;
        this.width=0;
        for (int i = 0; i < this.forme.length; i++) {
            for (int j = 0; j < this.forme[i].length; j++) {
                if (this.forme[i][j] == 1) {

                    this.height = (i > this.height) ? i : this.height;
                    this.width = (j > this.width) ? j : this.width;

                    x = j + this.getX();
                    y = (i + this.getY()) * 10;
                    this.coordonnees.add(x + y);
                }
            }
        }
    }



    public void roate(boolean left) {
        if(left) {
            Matrix.transpose(this.forme);
            Matrix.swapRows(this.forme);
        } else {
            Matrix.swapRows(this.forme);
            Matrix.transpose(this.forme);
        }
        computeCoordonnees();
    }

    public int[][] getForme() {
        return this.forme;
    }

    public int getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.computeCoordonnees();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.computeCoordonnees();
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

        this.computeCoordonnees();
    }


    public int getWidth() {
        return width;
    }

    public ArrayList<Integer> getCoordonnees() {
        return coordonnees;
    }
}
