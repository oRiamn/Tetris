package com.example.oriamn.tetris.GameComponnent;

import com.example.oriamn.tetris.GameCore;

/**
 * Un composant de jeu est relier à la console de jeux vidéos
 *
 * Created by oriamn on 29/06/17.
 */

public abstract class GameComponnent {

    protected GameCore core;

    public GameComponnent(GameCore core) {
        this.core = core;
    }

    private GameComponnent() {

    }
}
