package com.example.qoutes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentItemAdapter extends RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder> {
    private List<ParentItem> parentItemList;
    Context context;

    public ParentItemAdapter(Context context,List<ParentItem> parentItemList) {
        this.context = context;
        this.parentItemList = parentItemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parentrecycle, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        ParentItem parentItem = parentItemList.get(position);
        holder.parentTitle.setText(parentItem.getParentTitle());

        // Setup child RecyclerView
        GridLayoutManager layoutManager = new GridLayoutManager(context,2,LinearLayoutManager.HORIZONTAL,false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        ChildItemAdapter childAdapter = new ChildItemAdapter(context,parentItem.getChildItemList());
        holder.childRecyclerView.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView parentTitle;
        RecyclerView childRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            parentTitle = itemView.findViewById(R.id.parent_title);
            childRecyclerView = itemView.findViewById(R.id.child_recyclerview);
        }
    }
}
