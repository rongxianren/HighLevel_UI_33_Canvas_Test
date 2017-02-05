package com.rongxianren.highlevel_ui_33_canvas_test.canvasview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.rongxianren.highlevel_ui_33_canvas_test.R;

/**
 * Created by wty on 2017/1/19.
 */

public class CanvasView extends View {

    private Bitmap mBitmap;
    private int mWidth = 0;
    private int mHeight = 0;
    private Drawable mDrawable;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CanvasView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cute);
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
        mDrawable = getResources().getDrawable(R.drawable.cute);

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);

//        Rect rect = new Rect(0, 0, 200, 400);
//        canvas.drawRect(rect, paint);
//
//        canvas.translate(50, 50);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(rect, paint);
//
//        Rect rect1 = new Rect(200, 200, 400, 500);
//
//        Rect rect2 = new Rect(300, 300, 350, 350);
//        canvas.clipRect(rect2);
//
//
//        canvas.drawBitmap(mBitmap, null, paint);

        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.GREEN);
        shapeDrawable.setBounds(0, 0, mWidth / 2, mHeight);


        canvas.save();
        Rect clipRect = new Rect(0, 0, mWidth / 2, mHeight / 2);
        canvas.clipRect(clipRect);
        mDrawable.setBounds(clipRect);
        mDrawable.draw(canvas);
        canvas.restore();


        canvas.save();
        shapeDrawable.getPaint().setColor(Color.RED);
        Rect clipRect_1 = new Rect(0, mHeight / 2, mWidth / 2, mHeight);
        canvas.clipRect(clipRect_1);
        shapeDrawable.draw(canvas);
        canvas.restore();
    }
}
