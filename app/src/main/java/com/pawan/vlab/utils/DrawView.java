package com.pawan.vlab.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends View {
    private List<Path> paths;
    private List<Pair<Integer, Integer>> allConnections;
    private Path path;
    private Paint drawPaint;
    private Canvas canvas;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        allConnections = new ArrayList<>();
        setupPaint();
        paths = new ArrayList<>();
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        for (Path p : paths) {
            canvas.drawPath(p, drawPaint);
        }
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setStyle(Paint.Style.STROKE);
        int paintColor = Color.BLUE;
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(6);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void drawConnection(int start, int end, Point startPoint, Point endPoint) {
        if (checkDuplicate(start, end))
            return;
        path.moveTo(startPoint.x, startPoint.y);
        if (!(startPoint.x == endPoint.x || startPoint.y == endPoint.y)) {
            path.lineTo(startPoint.x, endPoint.y);
            path.moveTo(startPoint.x, endPoint.y);
        }
        path.lineTo(endPoint.x, endPoint.y);
        Pair<Integer, Integer> connection = new Pair<>(start, end);
        allConnections.add(connection);
        paths.add(path);
        invalidate();
        path = new Path();
    }


    private boolean checkDuplicate(int start, int end) {
        Pair<Integer, Integer> connection1 = new Pair<>(start, end);
        Pair<Integer, Integer> connection2 = new Pair<>(end, start);
        return allConnections.contains(connection2)
                || allConnections.contains(connection1);
    }

    public void undoAction() {
        if (!paths.isEmpty()) {
            paths.remove(paths.size() - 1);
            allConnections.remove(allConnections.size() - 1);
            invalidate();
        }
    }

    public int getNoOfConnections() {
        return paths.isEmpty() ? 0 : paths.size();
    }

    public List<Pair<Integer, Integer>> getAllConnections() {
        return allConnections;
    }

    public void setAllConnections(List<Pair<Integer, Integer>> allConnections) {
        this.allConnections = allConnections;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
