package com.example.glowgenie.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
        PopularDomain item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.price.setText(formatPrice(item.getPrice()));
        holder.loc.setText(item.getLocation());
        holder.img.setImageResource(item.getImgresource());

        // Set an OnClickListener to handle item clicks
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Shop1.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("location", item.getLocation());
                intent.putExtra("price", item.getPrice());
                intent.putExtra("imgresource", item.getImgresource());
                if (!(context instanceof Activity)) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private String formatPrice(int price) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        return "Rp " + format.format(price);
    }
}
