package com.example.glowgenie.booking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.glowgenie.R;

import com.example.glowgenie.booking.Doctor;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private List<Doctor> doctorList;
    private Context context;

    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_item, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position);
        holder.doctorName.setText(doctor.getName());
        holder.doctorImage.setImageResource(doctor.getImageResourceId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Booking.class);
            intent.putExtra("name", doctor.getName());
            intent.putExtra("imageResourceId", doctor.getImageResourceId());
            intent.putExtra("experience", doctor.getExperience());
            intent.putExtra("specialization", doctor.getSpecialization());
            intent.putExtra("clinic", doctor.getClinic());
            intent.putExtra("desc", doctor.getDesc());
            intent.putExtra("rating", doctor.getRating());
            intent.putExtra("reviews", doctor.getReviews());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {
        ImageView doctorImage;
        TextView doctorName;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorImage = itemView.findViewById(R.id.doctor_image);
            doctorName = itemView.findViewById(R.id.doctor_name);
        }
    }
}
