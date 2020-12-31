package org.deltaverse.stacktimer;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

import org.deltaverse.stacktimer.databinding.RootFragmentBinding;

import java.util.ArrayList;

public class RootFragment extends Fragment {

    private RootViewModel mViewModel;
    private RootFragmentBinding binding;

    public static RootFragment newInstance() {
        return new RootFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = RootFragmentBinding.inflate(inflater);
        binding.getRoot().setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_rootFragment2_to_aboutFragment2);
        });

        binding.cardStackView.setLayoutManager(new CardStackLayoutManager(getContext()));
        ArrayList<DataObject> dataObjects = new ArrayList<>();
        dataObjects.add(new DataObject("sai"));
        dataObjects.add(new DataObject("phani"));
        dataObjects.add(new DataObject("aditya"));
        dataObjects.add(new DataObject("jagatha"));
        binding.cardStackView.setAdapter(new CardStackAdapter(dataObjects, getContext()));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RootViewModel.class);
        // TODO: Use the ViewModel
    }

}