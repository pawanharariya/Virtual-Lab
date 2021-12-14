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

import com.pawan.vlab.databinding.FragmentExperimentListBinding;
import com.pawan.vlab.utils.Constants;
import com.pawan.vlab.utils.DataRepository;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class ExperimentListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentExperimentListBinding binding = FragmentExperimentListBinding.inflate(inflater, container, false);
        NavController navController = Navigation.findNavController(requireParentFragment().requireView());
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        experimentDataViewModel.setPaths(null);
        experimentDataViewModel.setAllConnections(null);
        binding.exp1Button.setOnClickListener(view -> {
            experimentDataViewModel.setExperimentData(DataRepository.getExperimentData(Constants.EXP_NUMBER_1));
            navController.navigate(R.id.exp_list_to_exp_home);
        });
        binding.exp2Button.setOnClickListener(view -> {
            experimentDataViewModel.setExperimentData(DataRepository.getExperimentData(Constants.EXP_NUMBER_2));
            navController.navigate(R.id.exp_list_to_exp_home);
        });
        binding.exp3Button.setOnClickListener(view -> {
            experimentDataViewModel.setExperimentData(DataRepository.getExperimentData(Constants.EXP_NUMBER_3));
            navController.navigate(R.id.exp_list_to_exp_home);
        });
        binding.exp4Button.setOnClickListener(view -> {
            experimentDataViewModel.setExperimentData(DataRepository.getExperimentData(Constants.EXP_NUMBER_4));
            navController.navigate(R.id.exp_list_to_exp_home);
        });
        return binding.getRoot();
    }
}
