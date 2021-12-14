package com.pawan.vlab.models;

import android.graphics.Point;
import android.widget.RadioButton;

public class StartInfo {
    private int start;
    private Point startPoint;
    private RadioButton startRadioButton;

    public StartInfo(int start, Point startPoint, RadioButton startRadioButton) {
        this.start = start;
        this.startPoint = startPoint;
        this.startRadioButton = startRadioButton;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public RadioButton getStartRadioButton() {
        return startRadioButton;
    }

    public void setStartRadioButton(RadioButton startRadioButton) {
        this.startRadioButton = startRadioButton;
    }
}
