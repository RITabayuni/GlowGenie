package com.example.glowgenie.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularViewHolder> {
    List<PopularDomain> items;
    Context context;

    public PopularAdapter(List<PopularDomain> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PopularViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.price.setText(items.get(position).getPrice());
        holder.loc.setText(items.get(position).getLocation());
        holder.img.setImageResource(items.get(position).getImgresource());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
