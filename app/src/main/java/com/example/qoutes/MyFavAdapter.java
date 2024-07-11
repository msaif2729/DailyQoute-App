package com.example.qoutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyFavAdapter extends RecyclerView.Adapter<MyFavAdapter.ViewHolder> {

    Context context;
    List<FavoriteData> favoriteData;

    DatabaseHandler databaseHandler;


    public MyFavAdapter(Context context, List<FavoriteData> favoriteData) {

        this.context = context;
        this.favoriteData = favoriteData;

    }

    @NonNull
    @Override
    public MyFavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.favoritelist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFavAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(favoriteData.get(position));
        holder.qoute.setText(favoriteData.get(position).getQoute());
        holder.author.setText(favoriteData.get(position).getAuthor());
        holder.date.setText(favoriteData.get(position).getDate());
        databaseHandler = new DatabaseHandler(context);

        holder.listlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "UNLIKE", Toast.LENGTH_SHORT).show();
                favoriteData.remove(holder.getAdapterPosition());
                databaseHandler.delliked(holder.qoute.getText().toString());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), favoriteData.size());

            }
        });

        holder.listshare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context,"SHARE", Toast.LENGTH_SHORT).show();
                Share.sharingqoute(context,holder.qoute.getText().toString());
            }
        });


    }

    @Override
    public int getItemCount() {
        return favoriteData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView qoute,author,date;
         ImageView listshare,listlike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            qoute = itemView.findViewById(R.id.qoute);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            listlike = itemView.findViewById(R.id.listlike);
            listshare = itemView.findViewById(R.id.listshare);









        }
    }
}
