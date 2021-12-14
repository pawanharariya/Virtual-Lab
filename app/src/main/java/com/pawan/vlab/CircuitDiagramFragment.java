package com.pawan.vlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pawan.vlab.databinding.FragmentCircuitDiagramBinding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class CircuitDiagramFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCircuitDiagramBinding binding = FragmentCircuitDiagramBinding.inflate(inflater, container, false);
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        ExperimentData experimentData = experimentDataViewModel.getExperimentData();
        binding.circuitDiagram.setBackgroundResource(experimentData.getCircuitDiagram());
        return binding.getRoot();
    }
}
