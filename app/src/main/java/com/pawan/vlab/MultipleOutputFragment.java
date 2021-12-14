package com.pawan.vlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.pawan.vlab.databinding.FragmentMultipleOutputBinding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class MultipleOutputFragment extends Fragment {
    private boolean inputButton = false, outputButton = true;
    private int selectedIndex = 0;
    private LineGraphSeries<DataPoint> inputGraph, outputGraph;
    private GraphView graph;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMultipleOutputBinding binding = FragmentMultipleOutputBinding.inflate(inflater, container, false);
        RadioButton inputWaveformButton = binding.inputWaveform;
        RadioButton outputWaveformButton = binding.outputWaveform;
        RadioGroup inputSignalGroup = binding.inputOptions;
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        ExperimentData experimentData = experimentDataViewModel.getExperimentData();
        graph = binding.graphview;
        inputGraph = experimentData.getInputGraphs().get(selectedIndex);
        outputGraph = experimentData.getOutputGraphs().get(selectedIndex);

        inputGraph.setColor(getResources().getColor(R.color.green));
        inputGraph.setAnimated(true);
        inputGraph.setTitle("Input waveform");

        outputGraph.setColor(getResources().getColor(R.color.blue));
        outputGraph.setAnimated(true);
        outputGraph.setTitle("Output waveform");

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-2.0);
        graph.getViewport().setMaxY(2.0);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setScalable(true);

        inputSignalGroup.setOnCheckedChangeListener((radioGroup, id) -> {
            if (id == R.id.input1) selectedIndex = 0;
            else if (id == R.id.input2) selectedIndex = 1;
//            else if (id == R.id.input3) selectedIndex = 2;
            inputGraph = experimentData.getInputGraphs().get(selectedIndex);
            outputGraph = experimentData.getOutputGraphs().get(selectedIndex);

            inputGraph.setColor(getResources().getColor(R.color.green));
            inputGraph.setAnimated(true);
            inputGraph.setTitle("Input waveform");
            outputGraph.setColor(getResources().getColor(R.color.blue));
            outputGraph.setAnimated(true);
            outputGraph.setTitle("Output waveform");
            graph.removeAllSeries();
            if(inputButton)
                graph.addSeries(inputGraph);
            if(outputButton)
                graph.addSeries(outputGraph);
        });

        graph.addSeries(outputGraph);
        outputWaveformButton.setChecked(true);

        inputWaveformButton.setOnClickListener(view -> {
            if (inputButton) {
                graph.removeSeries(inputGraph);
                inputButton = false;
                inputWaveformButton.setChecked(false);
            } else {
                inputButton = true;
                graph.addSeries(inputGraph);
                inputWaveformButton.setChecked(true);
            }
        });
        outputWaveformButton.setOnClickListener(view -> {
            if (outputButton) {
                outputWaveformButton.setChecked(false);
                graph.removeSeries(outputGraph);
                outputButton = false;
            } else {
                outputButton = true;
                outputWaveformButton.setChecked(true);
                graph.addSeries(outputGraph);
            }
        });
        return binding.getRoot();
    }
}
