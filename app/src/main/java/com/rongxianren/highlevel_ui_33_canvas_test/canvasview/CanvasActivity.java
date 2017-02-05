package com.rongxianren.highlevel_ui_33_canvas_test.canvasview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rongxianren.highlevel_ui_33_canvas_test.R;
import com.rongxianren.highlevel_ui_33_canvas_test.myrevealview.RevealDrawable;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //CanvasView canvasView = new CanvasView(this);
        Drawable darkDrawable = getResources().getDrawable(R.drawable.box_stack);
        Drawable lightDrawable = getResources().getDrawable(R.drawable.box_stack_active);
        final RevealDrawable revealDrawable = new RevealDrawable(darkDrawable, lightDrawable);
        revealDrawable.setLevel(0);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(revealDrawable);
//
//        System.out.println("-------CanvasActivity-------imageView.getWidth() =" + revealDrawable.getIntrinsicWidth());
//        System.out.println("-------CanvasActivity-------imageView.getHeight() =" + imageView.getHeight());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int level = revealDrawable.getLevel() + 50;
                revealDrawable.setLevel(level);
            }
        });

        setContentView(imageView);
    }
}
