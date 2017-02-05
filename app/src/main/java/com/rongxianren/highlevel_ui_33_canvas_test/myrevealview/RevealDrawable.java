package com.rongxianren.highlevel_ui_33_canvas_test.myrevealview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/**
 * Created by wty on 2017/2/3.
 */

public class RevealDrawable extends Drawable {


    private Drawable mDarkDrawable;
    private Drawable mLightDrawable;

    private int mDrawableWidth = 0;
    private int mDrawableHeight = 0;


    public RevealDrawable(Drawable darkDrawable, Drawable lightDrawable) {
        this.mDarkDrawable = darkDrawable;
        this.mLightDrawable = lightDrawable;
    }

    @Override
    public void draw(Canvas canvas) {
        mDrawableWidth = mDarkDrawable.getIntrinsicWidth();
        mDrawableHeight = mDarkDrawable.getIntrinsicHeight();

        int level = getLevel();
        Rect bounds = getBounds();
        if (level == 5000) {///全亮
            mLightDrawable.draw(canvas);
        } else if (level == 0 || level == 10000) {///全灰
            mDarkDrawable.draw(canvas);
        } else {////半亮半灰
            float ratio = level / 5000f - 1;  //// ratio between -1 and 1
            Rect outRect = new Rect();
            int height = bounds.height();
            int gravity = 0;
            //绘制亮色部分
            {
                int width = (int) (bounds.width() *(1 - Math.abs(ratio)));
                gravity = ratio < 0 ? Gravity.LEFT : Gravity.RIGHT;
                Gravity.apply(gravity, width, height, bounds, outRect);
                canvas.save();
                canvas.clipRect(outRect);
                mLightDrawable.draw(canvas);
                canvas.restore();
            }

            //绘制暗色部分
            {
                int width = (int) (bounds.width() * Math.abs(ratio));
                gravity = ratio < 0 ? Gravity.RIGHT : Gravity.LEFT;
                Gravity.apply(gravity, width, height, bounds, outRect);
                canvas.save();
                canvas.clipRect(outRect);
                mDarkDrawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        mDarkDrawable.setBounds(bounds);
        mLightDrawable.setBounds(bounds);
    }


    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public int getIntrinsicWidth() {
        return Math.max(mDarkDrawable.getIntrinsicWidth(), mLightDrawable.getIntrinsicWidth());
    }

    @Override
    public int getIntrinsicHeight() {
        return Math.max(mDarkDrawable.getIntrinsicHeight(), mLightDrawable.getIntrinsicHeight());
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
