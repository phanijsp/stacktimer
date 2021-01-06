package org.deltaverse.stacktimer;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

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

import java.util.concurrent.atomic.AtomicInteger;

public class RootFragment extends Fragment implements CardStackListener {

    private RootFragmentBinding binding;
    private CardStackLayoutManager cardStackLayoutManager;
    private CardStackAdapter cardStackAdapter;
    RootViewModel rootViewModel;
    CardObject lastCard;

    public static RootFragment newInstance() {
        return new RootFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = RootFragmentBinding.inflate(inflater);
        binding.getRoot().setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_rootFragment2_to_addCardFragment);
        });


        rootViewModel = new ViewModelProvider(this).get(RootViewModel.class);
        rootViewModel.isListEmpty().observe(getActivity(), aBoolean -> {
            if (!aBoolean) {
                lastCard = rootViewModel.getCards().getValue().get(0);
                initCardStackView();
            }else{
                rootViewModel.getCards();
            }
        });
        return binding.getRoot();
    }


    public void initCardStackView() {
        cardStackLayoutManager = new CardStackLayoutManager(this.getContext(), this);
        cardStackAdapter = new CardStackAdapter(rootViewModel.getCards().getValue(), getContext());
        cardStackLayoutManager.setVisibleCount(4);
        cardStackLayoutManager.setStackFrom(StackFrom.Bottom);
        cardStackLayoutManager.setTranslationInterval(12);
        binding.cardStackView.setLayoutManager(cardStackLayoutManager);
        binding.cardStackView.setAdapter(cardStackAdapter);
    }


    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {
        cardStackAdapter.dataObjects.remove(lastCard);
        cardStackAdapter.dataObjects.add(lastCard);
        lastCard = rootViewModel.getCards().getValue().get(0);
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