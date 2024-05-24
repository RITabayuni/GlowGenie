package com.example.glowgenie.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.text.BreakIterator;
import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalendarViewHolder> {
    Context context;
    private List<Item> items;

    public CalenderAdapter(Context applicationContext, List<Item> items) {
        this.items = items;
        this.context = context;
    }



    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CalendarViewHolder(LayoutInflater.from(context).inflate(R.layout.calendar_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.scheduleview.setText(items.get(position).getSchedule());
        holder.dayview.setText(items.get(position).getDaySkincare());
        holder.morningview.setText(items.get(position).getMorning());
        holder.nightview.setText(items.get(position).getNight());

    }

    @Override
    public int getItemCount() {
        return items.size();

    }

}
