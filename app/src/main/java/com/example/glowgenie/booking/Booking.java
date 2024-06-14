package com.example.glowgenie.booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.MainActivity;
import com.example.glowgenie.R;
import com.example.glowgenie.community.Community1;

public class Booking extends AppCompatActivity {

    ImageView bt_back;
    Button bt_booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bt_back = findViewById(R.id.back);
        bt_booking = findViewById(R.id.bt_booking);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Booking.this, FindDoctor.class);
                startActivity(intent);
//                finish();
            }
        });

        bt_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent B = new Intent(Booking.this, BookingPayment.class);
                startActivity(B);
            }
        });

        ImageView doctorImage = findViewById(R.id.img_doca21);
        TextView doctorName = findViewById(R.id.doc_name);
        TextView doctorExperience = findViewById(R.id.doc_experience);
        TextView doctorSpecialization = findViewById(R.id.specialist_doctor);
        TextView doctorClinic = findViewById(R.id.clinic_doctor);
        TextView doctorDesc = findViewById(R.id.description);
        TextView doctorRating = findViewById(R.id.textView11);
        TextView doctorReviews = findViewById(R.id.textView13);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imageResourceId = intent.getIntExtra("imageResourceId", -1);
        String experience = intent.getStringExtra("experience");
        String specialization = intent.getStringExtra("specialization");
        String clinic = intent.getStringExtra("clinic");
        String desc = intent.getStringExtra("desc");
        double rating = intent.getDoubleExtra("rating", 0);
        int reviews = intent.getIntExtra("reviews", 0);

        doctorImage.setImageResource(imageResourceId);
        doctorName.setText(name);
        doctorExperience.setText(experience);
        doctorSpecialization.setText(specialization);
        doctorClinic.setText(clinic);
        doctorDesc.setText(desc);
        doctorRating.setText(String.valueOf(rating));
        doctorReviews.setText(String.valueOf(reviews));

    }
}