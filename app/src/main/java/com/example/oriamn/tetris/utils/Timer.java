package com.example.oriamn.tetris.utils;

import android.os.Handler;

/**
 * Created by oriamn on 29/06/17.
 */

public class Timer implements Runnable {

    private boolean shouldIDoIt = true;

    private int duration;

    private Handler handler;

    private Runnable callback;

    public Timer(int duration, Runnable callback) {
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
