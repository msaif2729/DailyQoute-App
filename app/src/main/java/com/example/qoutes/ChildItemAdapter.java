package com.example.qoutes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ChildItemAdapter extends RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder> {
    private List<ChildItem> childItemList;
    Context context;


    public ChildItemAdapter(Context context,List<ChildItem> childItemList) {
        this.context = context;
        this.childItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.childrecycle, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        ChildItem childItem = childItemList.get(position);
        holder.childTitle.setText(childItem.getChildTitle());

        holder.child_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Topic : "+holder.childTitle.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,TopicQoute.class);
                intent.putExtra("topic",holder.childTitle.getText().toString());
                context.startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return childItemList.size();
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView childTitle;
       CardView child_card;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            childTitle = itemView.findViewById(R.id.child_title);
            child_card = itemView.findViewById(R.id.child_card);
        }
    }
}

