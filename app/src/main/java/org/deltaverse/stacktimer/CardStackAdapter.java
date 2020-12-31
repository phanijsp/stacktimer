package org.deltaverse.stacktimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    ArrayList<DataObject> dataObjects = new ArrayList<>();
    Context context;
    public CardStackAdapter(ArrayList<DataObject> dataObjects, Context context){
        this.dataObjects = dataObjects;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.test_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataObject dataObject = dataObjects.get(position);
        TextView textView = holder.itemView.findViewById(R.id.testLayoutText);
        textView.setText(dataObject.name);
    }

    @Override
    public int getItemCount() {
        return dataObjects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
