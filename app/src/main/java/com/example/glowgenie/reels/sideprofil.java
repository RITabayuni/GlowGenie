package com.example.glowgenie.reels;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glowgenie.R;

public class sideprofil extends AppCompatActivity {

    private ImageView rels;
    private ImageView bck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sideprofil);

        String nama = getIntent().getStringExtra("nama");

        ImageView butonbck = findViewById(R.id.back);
        TextView textViewJudul = findViewById(R.id.pp);

        textViewJudul.setText(nama);


        rels = findViewById(R.id.rels);
        bck = findViewById(R.id.back);

        rels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sideprofil.this, activityreels.class);
                startActivity(intent);
            }
        });

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sideprofil.this, activityreels.class);
                startActivity(intent);
            }
        });
    }
}
