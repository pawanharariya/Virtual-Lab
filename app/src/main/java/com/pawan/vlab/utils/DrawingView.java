package com.pawan.vlab.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {
    private final Path path = new Path();
    private Paint drawPaint;
    private final List<Point> pointsList;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        pointsList = new ArrayList<>();
        setupPaint();
    }

    // Get x and y and append them to the path
    public boolean onTouchEvent(MotionEvent event) {
        Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        Log.e("check", "touchPoint" + point.toString());
        // Checks for the event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                path.moveTo(point.x, point.y);
                pointsList.add(new Point((int)event.getRawX(),(int)event.getRawY()));
                break;
            case MotionEvent.ACTION_MOVE:
                // Draws line between last point and this point
                path.lineTo(point.x, point.y);
                break;
            case MotionEvent.ACTION_UP:
                pointsList.add(new Point((int)event.getRawX(),(int)event.getRawY()));
                break;
            default:
                return false;
        }
        postInvalidate(); // Indicate view should be redrawn
        return true; // Indicate we've consumed the touch
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, drawPaint);
    }

    private void setupPaint() {
        // same as before
        drawPaint = new Paint();
        drawPaint.setStyle(Paint.Style.STROKE);
        int paintColor = Color.BLACK;
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public List<Point> getPointsList() {
        return pointsList;
    }
}
