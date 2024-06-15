package com.example.glowgenie.reels;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.ArrayList;
import java.util.List;

public class sideprofil extends AppCompatActivity {

    private ImageView rels;
    private ImageView bck;
    RecyclerView recyclerView;
    List<String> abcd;
    List<Integer> abcdImage;
    adaptersideprofil adapter;

    @SuppressLint("MissingInflatedId")
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



        recyclerView = findViewById(R.id.recyclerView);
        abcd = new ArrayList<>();
        abcdImage = new ArrayList<>();

        abcd.add("24K");
        abcd.add("45K");
        abcd.add("65K");
        abcd.add("4.560");
        abcd.add("8K");
        abcd.add("12K");
        abcd.add("10K");
        abcd.add("56K");
        abcd.add("1.230");
        abcd.add("1.235");
        abcd.add("900");
        abcd.add("8.5K");


        abcdImage.add(R.drawable.relp1);
        abcdImage.add(R.drawable.relp2);
        abcdImage.add(R.drawable.relp3);
        abcdImage.add(R.drawable.relp4);
        abcdImage.add(R.drawable.relp5);
        abcdImage.add(R.drawable.relp6);
        abcdImage.add(R.drawable.relp7);
        abcdImage.add(R.drawable.relp8);
        abcdImage.add(R.drawable.relp9);
        abcdImage.add(R.drawable.relp10);
        abcdImage.add(R.drawable.relp11);
        abcdImage.add(R.drawable.relp12);


        adapter = new adaptersideprofil(this, abcd, abcdImage);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}