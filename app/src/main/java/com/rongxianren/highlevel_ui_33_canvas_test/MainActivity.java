package com.rongxianren.highlevel_ui_33_canvas_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.rongxianren.highlevel_ui_33_canvas_test.canvasview.CanvasActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void canvasView(View view) {
        Intent intent = new Intent(this, CanvasActivity.class);
        startActivity(intent);
    }
}
