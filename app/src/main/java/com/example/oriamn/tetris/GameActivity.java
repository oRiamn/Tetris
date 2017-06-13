package com.example.oriamn.tetris;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private GameCore gameCore;

    private ArrayList<Integer> blocks;

    private MyAdapter gridAdapter;

    public void onPause() {
        super.onPause();
    }

    public GameActivity() {
        this.blocks = new ArrayList();
    }

    private  static int mod (int a, int b) {
        int res = a % b;
        return (a - res) / b;
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
            this.blocks.add(Color.BLACK);
        }

        ViewGroup.LayoutParams layoutParams = gridview.getLayoutParams();

        layoutParams.width = width;
        layoutParams.height = height;

        gridAdapter = new MyAdapter(this);
        gridview.setAdapter(gridAdapter);
        gridview.setNumColumns(numColumns);

        gameCore = new GameCore(numBlocks);
    }

    public void right(View view) {
        // Kabloe

        this.blocks.set(10, Color.GREEN);
        gridAdapter.notifyDataSetChanged();
    }

    public void left(View view) {
        // Kabloe

        this.blocks.set(15, Color.RED);
        gridAdapter.notifyDataSetChanged();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
    }

    public class MyAdapter extends BaseAdapter {

        private Context mContext;

        public MyAdapter(Context c) {
            mContext = c;
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


