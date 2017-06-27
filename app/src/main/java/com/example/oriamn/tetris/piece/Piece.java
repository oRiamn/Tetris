package com.example.oriamn.tetris.piece;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by oriamn on 09/06/17.
 */

public abstract class Piece {

    private int color;

    private int[][] forme;

    private int width,height;

    private ArrayList<Integer> coordonnees;

    private int x, y;

    public static String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    private void randColor() {
        String color = "";

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        this.color = Color.parseColor(color);
    }

    protected Piece(int[][] forme) {
        this.forme = forme;

        randColor();

        this.coordonnees = new ArrayList<Integer>();
        this.computeCoordonnees();
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

    public int getWidth() {
        return width;
    }

    public ArrayList<Integer> getCoordonnees() {
        return coordonnees;
    }

    public void roate(boolean left) {
        if(left) {
            transpose(this.forme);
            swapRows(this.forme);
        } else {
            swapRows(this.forme);
            transpose(this.forme);
        }
        computeCoordonnees();
    }

    private static void transpose(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }

    private static void swapRows(int[][] m) {
        for (int  i = 0, k = m.length - 1; i < k; ++i, --k) {
            int[] x = m[i];
            m[i] = m[k];
            m[k] = x;
        }
    }
}
