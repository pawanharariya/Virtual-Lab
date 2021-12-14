package com.pawan.vlab.utils;

import android.graphics.Path;
import android.util.Pair;

import androidx.lifecycle.ViewModel;

import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.models.StartInfo;

import java.util.List;

public class ExperimentDataViewModel extends ViewModel {
    private ExperimentData experimentData;
    private List<Path> paths;
    private List<Pair<Integer, Integer>> allConnections;
    private StartInfo startInfo;

    public ExperimentData getExperimentData() {
        return experimentData;
    }

    public void setExperimentData(ExperimentData experimentData) {
        this.experimentData = experimentData;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public List<Pair<Integer, Integer>> getAllConnections() {
        return allConnections;
    }

    public void setAllConnections(List<Pair<Integer, Integer>> allConnections) {
        this.allConnections = allConnections;
    }

    public StartInfo getStartInfo() {
        return startInfo;
    }

    public void setStartInfo(StartInfo startInfo) {
        this.startInfo = startInfo;
    }

}
