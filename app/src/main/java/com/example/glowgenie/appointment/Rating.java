package com.example.glowgenie.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.R;

public class Rating extends AppCompatActivity {
    ImageView iconBack;
    Button btnSubmit;
    RatingBar rbRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Rating.this, Appointment.class);
                startActivity(I);
            }
        });
        rbRating = findViewById(R.id.rate_consultation);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = rbRating.getRating();

                if (rating == 0){
                    Toast.makeText(Rating.this, "Please rate the consultation before submitting.", Toast.LENGTH_SHORT).show();
                }else {
                    if (rating == 5){
                        Toast.makeText(Rating.this, "Great! We are glad you enjoyed our service!", Toast.LENGTH_SHORT).show();
                    } else if (rating >= 3.5) {
                        Toast.makeText(Rating.this, "Good! We hope to serve you better next time.", Toast.LENGTH_SHORT).show();
                    } else if (rating >= 2.5) {
                        Toast.makeText(Rating.this, "Acceptable! We appreciate your feedback for improvement.", Toast.LENGTH_SHORT).show();
                    } else if (rating > 0) {
                        Toast.makeText(Rating.this, "Poor! We apologize for any inconvenience caused.", Toast.LENGTH_SHORT).show();
                    }
                    Intent I = new Intent(Rating.this, AppointmentHistory.class);
                    startActivity(I);
                }

            }
        });

    }
}