package com.example.oriamn.tetris.utils;

/**
 * Classe utilitaire pour la gestion des matrices
 *
 * Created by oriamn on 29/06/17.
 */

public class Matrix {

    /**
     * Effectue la transposition d'une matrice carrée
     *
     * @param m Matrice à transposer
     */
    public static void transpose(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }

    }


    /**
     * Inverse l'ordre des lignes d'une matrice
     *
     * @param m Matrice à intervertir
     */
    public static void swapRows(int[][] m) {
        for (int  i = 0, k = m.length - 1; i < k; ++i, --k) {
            int[] x = m[i];
            m[i] = m[k];
            m[k] = x;
        }
    }

}
