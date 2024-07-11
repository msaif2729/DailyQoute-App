package com.example.qoutes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyInterestAdapter extends RecyclerView.Adapter<MyInterestAdapter.ViewHolder> {

    Context context;
    List<MyInterest> myInterests;
    public ArrayList<String> cats;
    private SessionMaintain sessionMaintain;
    String selectedcat;
    private String[] selectedcats;
    public MyInterestAdapter(Context context, List<MyInterest> myInterests,String selectedcat) {
        this.context = context;
        this.myInterests = myInterests;
        this.selectedcat = selectedcat;
    }

    @NonNull
    @Override
    public MyInterestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.interestlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyInterestAdapter.ViewHolder holder, int position) {
        sessionMaintain = new SessionMaintain(context);
        cats = new ArrayList<String>();
        holder.itemView.setTag(myInterests.get(position));
        holder.interesttxt.setText(myInterests.get(position).getCategorytxt());
        if(selectedcat!=null)
        {
            String str = selectedcat.substring(1,selectedcat.length()-1);
            selectedcats = str.split(", ");
            for(int i = 0;i<selectedcats.length;i++)
            {
                if(selectedcats[i].equals(holder.interesttxt.getText().toString()))
                {
                    holder.card.setChecked(true);
                }
                cats.add(selectedcats[i]);
            }
//            Log.d("Mohammed Saif",Arrays.toString(selectedcats));
        }
//        Toast.makeText(context, "chars : "+ Arrays.toString(selectedcats), Toast.LENGTH_SHORT).show();
        int imageResource = context.getResources().getIdentifier(myInterests.get(position).categoryimg, "drawable", context.getPackageName());
        Log.d("Mohammed Saif",myInterests.get(position).categoryimg);
        Picasso.get().load(imageResource).into(holder.interestimg);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.card.setChecked(!holder.card.isChecked());
                if(holder.card.isChecked())
                {
                    cats.add(holder.interesttxt.getText().toString());
//                    Toast.makeText(context, "Added : "+cats, Toast.LENGTH_SHORT).show();
                }
                else {
                    cats.remove(holder.interesttxt.getText().toString());
//                    Toast.makeText(context, "Removed : "+cats, Toast.LENGTH_SHORT).show();
                }

                sessionMaintain.category(String.valueOf(cats));
//                Toast.makeText(context, "Array : "+cats, Toast.LENGTH_SHORT).show();




            }
        });


    }

    @Override
    public int getItemCount() {
        return myInterests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView interesttxt;
        ImageView interestimg;
        MaterialCardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            interestimg = itemView.findViewById(R.id.interestimg);
            interesttxt = itemView.findViewById(R.id.interesttxt);
            card = itemView.findViewById(R.id.card);

        }
    }
}
