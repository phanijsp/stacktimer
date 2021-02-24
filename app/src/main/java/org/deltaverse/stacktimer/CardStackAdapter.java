package org.deltaverse.stacktimer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.deltaverse.stacktimer.databinding.CardLayoutBinding;

import java.util.ArrayList;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {
    ArrayList<CardObject> dataObjects = new ArrayList<>();
    Context context;
    public CardStackAdapter(ArrayList<CardObject> dataObjects, Context context){
        this.dataObjects = dataObjects;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardObject dataObject = dataObjects.get(position);
        TextView cardTitle = holder.binding.cardTitle;
        TextView cardCaption = holder.binding.cardCaption;
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, cardTitle.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        cardTitle.setText(dataObject.getCardTitle());
        cardCaption.setText(dataObject.getCardCaption());
        ConstraintLayout constraintLayout = holder.itemView.findViewById(R.id.rootCardBackground);
        int[] colors = new int[]{Color.GRAY, Color.BLUE, Color.YELLOW, Color.CYAN,Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN,Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN,Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN,Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN,Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN};
        constraintLayout.setBackgroundColor(dataObject.getCardColor());
    }

    @Override
    public int getItemCount() {
        return dataObjects.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardLayoutBinding binding;

        public ViewHolder(CardLayoutBinding cardLayoutBinding) {
            super(cardLayoutBinding.getRoot());
            this.binding = cardLayoutBinding;
        }
    }
}
