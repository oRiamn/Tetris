package com.example.oriamn.tetris.lib.componnent;

import android.os.Handler;

import com.example.oriamn.tetris.lib.GameCore;
import com.example.oriamn.tetris.lib.GameComponnent;

/**
 * Created by oriamn on 29/06/17.
 */

public class Timer extends GameComponnent implements Runnable {

    private boolean shouldIDoIt = true;

    private int duration;

    private Handler handler;

    private Runnable callback;

    public Timer(GameCore core, int duration, Runnable callback) {
        super(core);
        this.duration = duration;

        this.callback = callback;

        this.handler = new Handler();
        this.handler.postDelayed(this,this.duration);
    }

    public void run() {
        this.callback.run();

        if(shouldIDoIt){
            handler.postDelayed(this,this.duration);
        } else {
            handler.removeCallbacks(this);
        }
    }

    public boolean isShouldIDoIt() {
        return shouldIDoIt;
    }

    public void setShouldIDoIt(boolean shouldIDoIt) {
        this.shouldIDoIt = shouldIDoIt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
