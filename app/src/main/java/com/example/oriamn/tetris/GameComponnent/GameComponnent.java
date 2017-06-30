package com.example.oriamn.tetris.GameComponnent;

import com.example.oriamn.tetris.GameCore;

/**
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
