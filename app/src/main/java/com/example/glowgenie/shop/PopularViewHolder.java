package com.example.glowgenie.shop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

public class PopularViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView title, loc, price;

    public PopularViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        title = itemView.findViewById(R.id.Product_Name);
        loc = itemView.findViewById(R.id.Product_Loc);
        price = itemView.findViewById(R.id.Product_Price);
    }
}
