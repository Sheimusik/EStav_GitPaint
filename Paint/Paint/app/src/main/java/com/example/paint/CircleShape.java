package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CircleShape extends AreaShapes {

    private int xEnd;
    private int yEnd;
    private float cx;
    private float cy;
    private double radius;
    private boolean isFilled;

    public CircleShape(int x, int y, String color, boolean filled) {
        super(x, y, color);
        xEnd = x;
        yEnd = y;
        isFilled = filled;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        xEnd = xe;
        yEnd = ye;
        cx = (x + xEnd) / 2;
        cy = (y + yEnd) / 2;
        radius = Math.sqrt((xEnd - x)*(xEnd - x)+(yEnd - y)*(yEnd - y));
    }

    @Override
    public double getArea() {
        return 3.14 * Math.pow(radius, 2);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas,paint);
        paint.setStrokeWidth(8);
        if(isFilled == true)
            paint.setStyle(Paint.Style.FILL);
        if(isFilled == false)
            paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx,cy,(float)radius / 2,paint);
    }
}