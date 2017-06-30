package com.example.oriamn.tetris.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color; 
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class BlockView extends AppCompatImageView {

    private int color;

    public BlockView(Context context) {
        super(context);

        color = Color.BLACK; 
    }

    public BlockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key that will make the height equivalent to its width
    }


}
