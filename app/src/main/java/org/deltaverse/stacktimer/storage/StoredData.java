package org.deltaverse.stacktimer.storage;

import android.content.Context;
import android.content.SharedPreferences;

import org.deltaverse.stacktimer.beans.CardObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoredData {
    private Context context;
    public StoredData(Context context){
        this.context = context;
    }

    public void saveCards(ArrayList<CardObject> cardObjects){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(cardObjects);
            SharedPreferences sharedPreferences = context.getSharedPreferences("StoredCards",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Cards", new String(byteArrayOutputStream.toByteArray()));
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<CardObject> getSavedCards(){
        ArrayList<CardObject> cardObjects = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences("StoredCards",Context.MODE_PRIVATE);
        String savedString = sharedPreferences.getString("Cards","null");
        if(!savedString.equals("null")){
            byte[] bytes = savedString.getBytes();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Object o = objectInputStream.readObject();
                cardObjects = (ArrayList<CardObject>) o;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cardObjects;
    }
}
