package com.pawan.vlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.pawan.vlab.databinding.FragmentOutputBinding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class OutputFragment extends Fragment {
    private boolean inputButton = false, outputButton = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentOutputBinding binding = FragmentOutputBinding.inflate(inflater, container, false);
        RadioButton inputWaveformButton = binding.inputWaveform;
        RadioButton outputWaveformButton = binding.outputWaveform;
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        ExperimentData experimentData = experimentDataViewModel.getExperimentData();
        LineGraphSeries<DataPoint> inputGraph = experimentData.getInputGraphs().get(0);
        LineGraphSeries<DataPoint> outputGraph = experimentData.getOutputGraphs().get(0);
        GraphView graph = binding.graphview;
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
