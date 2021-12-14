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

import com.pawan.vlab.databinding.FragmentTheoryBinding;
import com.pawan.vlab.models.ExperimentData;
import com.pawan.vlab.utils.ExperimentDataViewModel;

public class TheoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTheoryBinding binding = FragmentTheoryBinding.inflate(inflater, container, false);
        ExperimentDataViewModel experimentDataViewModel = new ViewModelProvider(requireActivity()).get(ExperimentDataViewModel.class);
        ExperimentData experimentData = experimentDataViewModel.getExperimentData();
        NavController navController = Navigation.findNavController(requireParentFragment().requireView());
        binding.theory.setText(experimentData.getTheory());
        binding.nameOfExp.setText(experimentData.getTitle());
        binding.readArticleButton.setOnClickListener(view -> navController.navigate(R.id.exp_theory_to_theory_article));
        return binding.getRoot();
    }
}
