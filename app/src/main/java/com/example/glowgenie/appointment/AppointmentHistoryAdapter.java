package com.example.glowgenie.appointment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.List;

public class AppointmentHistoryAdapter extends RecyclerView.Adapter<AppointmentHistoryAdapter.ViewHolder> {
    private Context context;
    private List<AppointmentHistoryModel> appointmentHistoryList;

    public AppointmentHistoryAdapter(Context context, List<AppointmentHistoryModel> appointmentHistoryList) {
        this.context = context;
        this.appointmentHistoryList = appointmentHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_appointment_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppointmentHistoryModel item = appointmentHistoryList.get(position);

        holder.tv_doctorName.setText(item.getDoctorName());
        holder.tv_date.setText(item.getDate().toString());
        holder.tv_diagnosis.setText(item.getDiagnosis());
        holder.tv_complaint.setText(item.getComplaint());
        holder.tv_drugTherapy.setText(item.getDrugTherapy());
        holder.img_doctorImage.setImageResource(item.getDoctorImage());
        holder.img_rating.setImageResource(item.getRatingImage());
    }

    @Override
    public int getItemCount() {
        return appointmentHistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_doctorName, tv_date, tv_diagnosis, tv_complaint, tv_drugTherapy;
        ImageView img_doctorImage, img_rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_doctorName = itemView.findViewById(R.id.tv_doctorName);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_diagnosis = itemView.findViewById(R.id.tv_diagnosis);
            tv_complaint = itemView.findViewById(R.id.tv_complaint);
            tv_drugTherapy = itemView.findViewById(R.id.tv_drugTherapy);
            img_doctorImage = itemView.findViewById(R.id.img_doctor);
            img_rating = itemView.findViewById(R.id.img_rating);
        }
    }
}
