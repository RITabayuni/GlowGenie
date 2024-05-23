package com.example.glowgenie.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentHistory extends AppCompatActivity {
    ImageView iconBack;
    private RecyclerView recyclerView;
    private AppointmentHistoryAdapter appointmentHistoryAdapter;
    private ArrayList<AppointmentHistoryModel> appointmentHistoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(AppointmentHistory.this, Appointment.class);
                startActivity(I);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the data list
        appointmentHistoryList.add(new AppointmentHistoryModel("dr. Cameron Williamson", LocalDate.of(2024, 3, 17), "Inflamed acne, Post-inflammatory Erythema (PIE)", "Sore face", "Medi-klin gel 30g", R.drawable.doc_a1, R.drawable.stars));


        // Initialize the adapter and set it to the RecyclerView
        appointmentHistoryAdapter = new AppointmentHistoryAdapter(this, appointmentHistoryList);
        recyclerView.setAdapter(appointmentHistoryAdapter);
    }
}