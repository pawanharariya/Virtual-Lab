package com.pawan.vlab.utils;

import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.pawan.vlab.models.StartInfo;

import java.util.List;

public class HelperMethods {
    @NonNull
    private static Point getCoordinates(View view) {
        int[] point1 = new int[2];
        Point point = new Point();
        view.getLocationOnScreen(point1);
        point.x = point1[0] + 27;
        point.y = point1[1] - 138;
        return point;
    }

    public static void connect(StartInfo startInfo, RadioButton currentButton, int viewNumber, View currentView,
                               DrawViewListener drawViewListener) {
        int start = startInfo.getStart();
        Point startPoint = startInfo.getStartPoint();
        Point currentPoint = getCoordinates(currentView);
        RadioButton startRadioButton = startInfo.getStartRadioButton();
        if (viewNumber == start) {
            start = 0;
            startPoint = null;
            startRadioButton = null;
            currentButton.setChecked(false);
        } else if (start == 0) {
            start = viewNumber;
            startPoint = currentPoint;
            startRadioButton = currentButton;
        } else {
            drawViewListener.drawConnection(start, viewNumber, startPoint, currentPoint);
            start = 0;
            startPoint = null;
            currentButton.setChecked(false);
            startRadioButton.setChecked(false);
        }
        startInfo.setStart(start);
        startInfo.setStartPoint(startPoint);
        startInfo.setStartRadioButton(startRadioButton);
    }

    public static boolean checkConnection(List<Pair<Integer, Integer>> madeConnections,
                                          List<Pair<Integer, Integer>> validConnections, int validNoOfConnections) {
        if (madeConnections.isEmpty() || madeConnections.size() != validNoOfConnections
                || madeConnections.size() != validConnections.size())
            return false;
        for (Pair<Integer, Integer> pair : validConnections) {
            if (!madeConnections.contains(pair) && !madeConnections.contains(new Pair<>(pair.second, pair.first)))
                return false;
        }
        return true;
    }

    public interface DrawViewListener {
        void drawConnection(int start, int end, Point startPoint, Point endPoint);
    }

}
