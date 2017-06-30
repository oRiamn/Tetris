package com.example.oriamn.tetris.utils;

import android.graphics.Color;

import com.example.oriamn.tetris.lib.piece.CubePiece;
import com.example.oriamn.tetris.lib.piece.IPiece;
import com.example.oriamn.tetris.lib.piece.JPiece;
import com.example.oriamn.tetris.lib.piece.LPiece;
import com.example.oriamn.tetris.lib.Piece;
import com.example.oriamn.tetris.lib.piece.SPiece;
import com.example.oriamn.tetris.lib.piece.TPiece;
import com.example.oriamn.tetris.lib.piece.ZPiece;

import java.util.Random;

/**
 * Utilitaire aléatoire
 *
 * Created by oriamn on 29/06/17.
 */

public class Rand {

    /**
     * Liste de coleurs pour alimenter la fonction aléatoire
     */
    private static String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
    };

    /**
     * Retourne une couleur aléatoire dans la liste de couleur
     * @return Code de la couleur
     */
    public static int getColor() {

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);

        String color = mColors[randomNumber];
        int colorCode =  Color.parseColor(color);

        return colorCode;
    }

    /**
     * Retourne une instance de piece de manière aléatoire
     * @return La piece générée
     */
    public static Piece getPiece() {
        Piece piece = null;

        int maximum = 7;
        int minimum = 1;

        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int randomNum = minimum + i;

        switch (randomNum) {
            case 1 :
                piece = new CubePiece();
                break;
            case 2 :
                piece = new IPiece();
                break;
            case 3 :
                piece = new SPiece();
                break;
            case 4 :
                piece = new ZPiece();
                break;
            case 5 :
                piece = new JPiece();
                break;
            case 6 :
                piece = new LPiece();
                break;
            default:
                piece = new TPiece();
        }

        return piece;
    }
}
