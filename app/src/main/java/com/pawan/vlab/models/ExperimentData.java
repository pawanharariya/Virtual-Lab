package com.pawan.vlab.models;

import android.util.Pair;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

public class ExperimentData {
    private String aim, theory, title, url;
    private List<String> componentsRequired;
    private int expNumber, circuitDiagram, outputWaveform, inputWaveform;
    private List<Pair<Integer, Integer>> validConnections;
    private List<LineGraphSeries<DataPoint>> inputGraphs;
    private List<LineGraphSeries<DataPoint>> outputGraphs;

    public ExperimentData(int expNumber, String title, String aim, String theory, String url, List<String> componentsRequired, int circuitDiagram,
                          int outputWaveform, int inputWaveform, List<Pair<Integer, Integer>> validConnections,
                          List<LineGraphSeries<DataPoint>> inputGraphs, List<LineGraphSeries<DataPoint>> outputGraphs) {
        this.aim = aim;
        this.title = title;
        this.expNumber = expNumber;
        this.theory = theory;
        this.url = url;
        this.componentsRequired = componentsRequired;
        this.circuitDiagram = circuitDiagram;
        this.outputWaveform = outputWaveform;
        this.inputWaveform = inputWaveform;
        this.validConnections = validConnections;
        this.inputGraphs = inputGraphs;
        this.outputGraphs = outputGraphs;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getComponentsRequired() {
        StringBuilder sb = new StringBuilder();
        for (String s : componentsRequired)
            sb.append(s).append(", ");
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void setComponentsRequired(List<String> componentsRequired) {
        this.componentsRequired = componentsRequired;
    }

    public int getCircuitDiagram() {
        return circuitDiagram;
    }

    public void setCircuitDiagram(int circuitDiagram) {
        this.circuitDiagram = circuitDiagram;
    }

    public int getOutputWaveform() {
        return outputWaveform;
    }

    public void setOutputWaveform(int outputWaveform) {
        this.outputWaveform = outputWaveform;
    }

    public int getInputWaveform() {
        return inputWaveform;
    }

    public void setInputWaveform(int inputWaveform) {
        this.inputWaveform = inputWaveform;
    }

    public List<Pair<Integer, Integer>> getValidConnections() {
        return validConnections;
    }

    public void setValidConnections(List<Pair<Integer, Integer>> validConnections) {
        this.validConnections = validConnections;
    }

    public List<LineGraphSeries<DataPoint>> getInputGraphs() {
        return inputGraphs;
    }

    public void setInputGraphs(List<LineGraphSeries<DataPoint>> inputGraphs) {
        this.inputGraphs = inputGraphs;
    }

    public List<LineGraphSeries<DataPoint>> getOutputGraphs() {
        return outputGraphs;
    }

    public void setOutputGraphs(List<LineGraphSeries<DataPoint>> outputGraphs) {
        this.outputGraphs = outputGraphs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getExpNumber() {
        return expNumber;
    }

    public void setExpNumber(int expNumber) {
        this.expNumber = expNumber;
    }
}
