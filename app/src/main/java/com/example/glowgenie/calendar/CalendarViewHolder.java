package com.example.glowgenie.calendar;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewHolder extends RecyclerView.ViewHolder {

    TextView scheduleview, dayview, morningview, nightview;

    public CalendarViewHolder(@NonNull View itemView) {
        super(itemView);
        this.scheduleview = scheduleview;
        this.dayview = dayview;
        this.morningview = morningview;
        this.nightview = nightview;
    }

}
