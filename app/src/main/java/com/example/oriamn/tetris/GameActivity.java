package com.example.oriamn.tetris;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.oriamn.tetris.lib.GameCore;
import com.example.oriamn.tetris.utils.BlockView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private GameCore gameCore;

    private ViewAdapter gridAdapter;

    public void onPause() {
        super.onPause();
    }

    public GameActivity() {

    }

    private  static int mod (int a, int b) {
        int res = a % b;
        return (a - res) / b;
    }

    public static void restartActivity(Activity act){
        Intent intent=new Intent();
        intent.setClass(act, act.getClass());
        act.startActivity(intent);
        act.finish();

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        setContentView(R.layout.activity_game);

        GridView gridview = (GridView) findViewById(R.id.gridview);


        gridAdapter = new ViewAdapter(this);

        int numColumns = 10;

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x - 350;
        int height = size.y - 200;


        int caseSize =  (int) Math.floor(width/numColumns);

        int numRows = mod(height, caseSize);
        int numBlocks = numRows*numColumns;

        for(int i = 0; i < numBlocks; i++) {
            this.gridAdapter.blocks.add(Color.BLACK);
        }

        ViewGroup.LayoutParams layoutParams = gridview.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        gridview.setAdapter(gridAdapter);
        gridview.setNumColumns(numColumns);

        final GameActivity act = this;

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Fin du jeu?");
        alertDialog.setMessage("Vous avez perdu!! Voulez vous rejouer?");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OUI! C'est trop un bon jeu!!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        act.restartActivity(act);
                    }
                });

        this.gameCore = new GameCore(gridAdapter, numBlocks, alertDialog);
    }

    public void right(View view) {
        // Kabloe
        this.gameCore.getControls().right();
    }

    public void left(View view) {
        this.gameCore.getControls().left();
    }

    public void rotateG(View view) {
        this.gameCore.getControls().rotate(true);
    }

    public void rotateD(View view) {
        this.gameCore.getControls().rotate(false);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
    }

    public class ViewAdapter extends BaseAdapter {

        public ArrayList<Integer> blocks;

        private Context mContext;

        public ViewAdapter(Context c) {
            mContext = c;
            this.blocks = new ArrayList();
        }

        @Override
        public int getCount() {
            return blocks.size();
        }

        @Override
        public Object getItem(int arg0) {
            return (int) blocks.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View grid;

            if(convertView==null){
                grid = new View(mContext);
                LayoutInflater inflater=getLayoutInflater();
                grid=inflater.inflate(R.layout.gamegrid, parent, false);
            }else{
                grid = (View)convertView;
            }


            BlockView imageView = (BlockView) grid.findViewById(R.id.image);
            imageView.setBackgroundColor(blocks.get(position));

            if(blocks.get(position) == Color.BLACK){
                imageView.setImageResource(R.drawable.empty);
            } else {
                imageView.setImageResource(R.drawable.block);
            }


            return grid;
        }
    }
}


