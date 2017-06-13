package com.example.oriamn.tetris;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by oriamn on 09/06/17.
 */

public class GameCore {

    private ArrayList<Integer> blocks;

    private Handler myHandler;
    private Runnable horloge = new Runnable() {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique

            myHandler.postDelayed(this,500);
        }
    };



    public GameCore(int numBlocks) {

        myHandler = new Handler();
        myHandler.postDelayed( horloge,500); // on redemande toute les 500ms

        blocks = new ArrayList<Integer>();
        for(int i = 0; i < numBlocks; i++) {
            this.blocks.add(0);
        }
    }



    public void onPause() {
        if(myHandler != null)
            myHandler.removeCallbacks( horloge);
    }
}
