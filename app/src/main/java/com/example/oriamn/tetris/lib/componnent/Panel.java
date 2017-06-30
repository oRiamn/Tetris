package com.example.oriamn.tetris.lib.componnent;

import com.example.oriamn.tetris.lib.GameComponnent;
import com.example.oriamn.tetris.lib.GameCore;

/**
 *
 *
 * Created by oriamn on 30/06/17.
 */
public class Panel extends GameComponnent {

    private Runnable refresh;

    private int level;

    private int nbLigne;

    public int getScore() {
        return score;
    }

    private int score;

    public Panel(GameCore core) {
        super(core);
    }

    public int getNbLigne() {
        return nbLigne;
    }

    public int getLevel() {
        return level;
    }

    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
    }

    public void incrementLigne(int nbLigne){
        this.nbLigne += nbLigne;

        switch (nbLigne) {
            case 1:
                this.score += 40 * (this.level + 1);
                break;

            case 2:
                this.score += 100 * (this.level + 1);
                break;

            case 3:
                this.score += 300 * (this.level + 1);
                break;

            case 4:
                this.score += 1200 * (this.level + 1);
                break;
        }

        if (this.level < 20){
            this.level += nbLigne;
        }

        if(refresh != null){
            refresh.run();
        }
    }

    public void setRefresh(Runnable refresh) {
        this.refresh = refresh;
    }
}
