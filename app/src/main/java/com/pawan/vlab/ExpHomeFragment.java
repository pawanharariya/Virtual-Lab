package com.pawan.vlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.pawan.vlab.databinding.FragmentExpHomeBinding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class ExpHomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentExpHomeBinding binding = FragmentExpHomeBinding.inflate(inflater, container, false);
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        ExperimentData experimentData = experimentDataViewModel.getExperimentData();
        binding.aimDisplay.setText(experimentData.getAim());
        binding.componentsDisplay.setText(experimentData.getComponentsRequired());
        binding.theoryDisplay.setText(experimentData.getTheory());
        binding.nameOfExp.setText(experimentData.getTitle());
        int expNumber = experimentData.getExpNumber();
        NavController navController = Navigation.findNavController(requireParentFragment().requireView());
        binding.performExperimentButton.setOnClickListener(view -> {
            int action;
            switch (expNumber) {
                case 1:
                    action = R.id.exp_home_to_exp_1;
                    break;
                case 2:
                    action = R.id.exp_home_to_exp_2;
                    break;
                case 3:
                    action = R.id.exp_home_to_exp_3;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + expNumber);
            }
            navController.navigate(action);
        });
        binding.readMoreLabel.setOnClickListener(view -> navController.navigate(R.id.exp_home_to_exp_theory));
        binding.circuitDiagramButton.setOnClickListener(view -> navController.navigate(R.id.exp_home_to_circuit_diagram));
        return binding.getRoot();
    }
}
