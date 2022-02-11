package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.UUID;

public class PaintActivity extends AppCompatActivity {
    private static final String TAG = "PaintActivity";
    private FrameLayout frame;
    private PaintView paintView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        frame = findViewById(R.id.frm);
        paintView = new PaintView(this);
        button = findViewById(R.id.btnPoint);
        frame.addView(paintView);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                paintView.pathRemove();
                return true;
            }
        });
    }

    public void addLine(View view) {
        paintView.addLine();
    }
    public void addRect(View view) {
        paintView.addRect();
    }
    public void addPath(View view) {
        paintView.addPath();
    }
    public void addCircle(View view) {
        paintView.addCircle();
    }

    public void changeColor(View view)
    {
        String color = view.getTag().toString();
        paintView.setColor(color);
    }
    
    public void clear(View view)
    {
        paintView.undo();
    }
    public void fill(View view)
    {
        paintView.fill();
    }
    public void changeWidth(View view)
    {
        paintView.changeWidth();
    }
    public void leaveBiggest(View view)
    {
        paintView.leaveBiggest();
    }
    public void saveImage(View view)
    {
        paintView.setDrawingCacheEnabled(true);
        MediaStore.Images.Media.insertImage(getContentResolver(), paintView.getDrawingCache(), UUID.randomUUID().toString()+".png", "drawing");
        paintView.destroyDrawingCache();
    }
}
