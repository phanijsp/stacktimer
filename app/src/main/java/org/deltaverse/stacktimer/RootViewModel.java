package org.deltaverse.stacktimer;


import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class RootViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<CardObject>> cardObjectsLive;
    private MutableLiveData<Boolean> listEmpty = new MutableLiveData<>(true);

    public LiveData<ArrayList<CardObject>> getCards() {
        if (cardObjectsLive == null) {
            cardObjectsLive = new MutableLiveData<ArrayList<CardObject>>();
            loadCards();
        }


        return cardObjectsLive;
    }

    private void loadCards() {
        ArrayList<CardObject> cardObjects = new ArrayList<>();

        cardObjects.add(new CardObject("Sai","","","", Color.GRAY));
        cardObjects.add(new CardObject("Sa1i","","","", Color.GREEN));

        cardObjects.add(new CardObject("Sai2","","","", Color.CYAN));

        cardObjects.add(new CardObject("Sai3","","","", Color.BLUE));

//        cardObjects.add(new CardObject("sai"));
//        cardObjects.add(new CardObject("phani"));
//        cardObjects.add(new CardObject("aditya"));
//        cardObjects.add(new CardObject("jagatha"));
        cardObjectsLive.setValue(cardObjects);

        if (cardObjects.size() > 0) {
            listEmpty.setValue(false);
        }
    }

    public LiveData<Boolean> isListEmpty() {
        if (cardObjectsLive != null) {
            if (cardObjectsLive.getValue().size() > 0) {
                listEmpty.setValue(false);
            }
        }
        return listEmpty;
    }
}