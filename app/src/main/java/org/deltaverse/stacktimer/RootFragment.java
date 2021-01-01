package org.deltaverse.stacktimer;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import org.deltaverse.stacktimer.databinding.RootFragmentBinding;

import java.util.ArrayList;

public class RootFragment extends Fragment implements CardStackListener {

    private RootViewModel mViewModel;
    private RootFragmentBinding binding;
    private CardStackLayoutManager cardStackLayoutManager;
    private CardStackAdapter cardStackAdapter;
    DataObject lastItem;
    ArrayList<DataObject> dataObjects;

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

        dataObjects = new ArrayList<>();

        cardStackLayoutManager = new CardStackLayoutManager(this.getContext(), this);
        cardStackAdapter = new CardStackAdapter(dataObjects, getContext());
        cardStackLayoutManager.setVisibleCount(3);
        cardStackLayoutManager.setStackFrom(StackFrom.Bottom);
        binding.cardStackView.setLayoutManager(cardStackLayoutManager);
        dataObjects.add(new DataObject("sai"));
        dataObjects.add(new DataObject("phani"));
        dataObjects.add(new DataObject("aditya"));
        dataObjects.add(new DataObject("jagatha"));
        lastItem = dataObjects.get(0);
        binding.cardStackView.setAdapter(cardStackAdapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RootViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {
        cardStackAdapter.dataObjects.remove(lastItem);
        cardStackAdapter.dataObjects.add(lastItem);
        lastItem = dataObjects.get(0);
        cardStackAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }
}