package com.example.glowgenie.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.R;

public class Appointment extends AppCompatActivity implements View.OnClickListener{
    CardView cvToday, cvToday2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_appointment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cvToday = findViewById(R.id.cv_today);
        cvToday2 = findViewById(R.id.cv_today2);
        cvToday.setOnClickListener(this);
        cvToday2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent I = new Intent(Appointment.this, Appointment3.class);

        String doctorName = null;

        if (v.getId() == R.id.cv_today) {
            TextView tvDoctorName = findViewById(R.id.dr_name1);
            doctorName = tvDoctorName.getText().toString();
        } else if (v.getId() == R.id.cv_today2) {
            TextView tvDoctorName = findViewById(R.id.dr_name2);
            doctorName = tvDoctorName.getText().toString();
        }
        I.putExtra("docName", doctorName);
        startActivity(I);
    }

}