package com.pawan.vlab;

import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pawan.vlab.databinding.FragmentExp1Binding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.models.StartInfo;
import com.pawan.vlab.utils.DrawView;
import com.pawan.vlab.utils.ExperimentDataViewModel;
import com.pawan.vlab.utils.HelperMethods;

public class Exp1Fragment extends Fragment implements HelperMethods.DrawViewListener {
    private RadioButton terminal1, terminal2, terminal3, terminal4, terminal5, terminal6;
    private Button checkConnection, undoButton, output;
    private DrawView drawView;
    private FragmentExp1Binding binding;
    private ExperimentData experimentData;
    private ExperimentDataViewModel experimentDataViewModel;
    private StartInfo startInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentExp1Binding.inflate(inflater, container, false);
        initUI();
        experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        experimentData = experimentDataViewModel.getExperimentData();
        checkConnection.setOnClickListener(view -> checkConnection());
        startInfo = new StartInfo(0, null, null);
        if (experimentDataViewModel.getPaths() != null && experimentDataViewModel.getAllConnections() != null) {
            drawView.setPaths(experimentDataViewModel.getPaths());
            drawView.setAllConnections(experimentDataViewModel.getAllConnections());
            startInfo = experimentDataViewModel.getStartInfo();
        }
        NavController navController = Navigation.findNavController(requireParentFragment().requireView());
        terminal1.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal1, 1, view, this));
        terminal2.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal2, 2, view, this));
        terminal3.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal3, 3, view, this));
        terminal4.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal4, 4, view, this));
        terminal5.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal5, 5, view, this));
        terminal6.setOnClickListener(view -> HelperMethods.connect(startInfo, terminal6, 6, view, this));

        undoButton.setOnClickListener(view -> drawView.undoAction());
        output.setOnClickListener(view -> {
            if (checkConnection()) navController.navigate(R.id.exp_1_to_output);
        });
        return binding.getRoot();
    }

    private void initUI() {
        terminal1 = binding.terminal1;
        terminal2 = binding.terminal2;
        terminal3 = binding.terminal3;
        terminal4 = binding.terminal4;
        terminal5 = binding.terminal5;
        terminal6 = binding.terminal6;
        drawView = binding.drawingView;
        checkConnection = binding.checkConnection;
        undoButton = binding.undoButton;
        output = binding.output;
    }

    @Override
    public void drawConnection(int start, int end, Point startPoint, Point endPoint) {
        drawView.drawConnection(start, end, startPoint, endPoint);
        experimentDataViewModel.setPaths(drawView.getPaths());
        experimentDataViewModel.setAllConnections(drawView.getAllConnections());
        experimentDataViewModel.setStartInfo(startInfo);
    }

    private boolean checkConnection() {
        if (HelperMethods.checkConnection(drawView.getAllConnections(),
                experimentData.getValidConnections(), drawView.getNoOfConnections())) {
            Toast.makeText(getContext(), "Correct Connection", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(getContext(), "Incorrect Connection", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
