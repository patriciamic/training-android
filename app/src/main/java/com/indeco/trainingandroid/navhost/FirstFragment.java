package com.indeco.trainingandroid.navhost;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indeco.trainingandroid.R;

public class FirstFragment extends Fragment {

    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initNavController();

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        view.findViewById(R.id.btnGoToSecond).setOnClickListener(v -> {
            navController.navigate(R.id.action_firstFragment_to_secondFragment);
        });

        return view;
    }

    private void initNavController() {
        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity()
                        .getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
    }
}