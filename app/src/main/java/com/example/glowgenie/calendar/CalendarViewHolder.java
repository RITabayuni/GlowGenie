package com.example.glowgenie.calendar;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

public class CalendarViewHolder extends RecyclerView.ViewHolder {

    TextView scheduleview, dayview, morningview, nightview;

    public CalendarViewHolder(@NonNull View itemView) {
        super(itemView);
        scheduleview = itemView.findViewById(R.id.schedule);
        dayview = itemView.findViewById(R.id.dayskincare);
        morningview = itemView.findViewById(R.id.morningskincare);
        nightview = itemView.findViewById(R.id.nightskincare);

    }
}
