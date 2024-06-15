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

public class sharebutton extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> abcd;
    List<Integer> abcdImage;
    adaptersharebutton adapter;
    private ImageView bck;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharebutton);

        recyclerView = findViewById(R.id.recyclerView2);
        abcd = new ArrayList<>();
        abcdImage = new ArrayList<>();

        abcd.add("Facebook");
        abcd.add("Whats App");
        abcd.add("Instagram");
        abcd.add("X");
        abcd.add("Message");
        abcd.add("Bluetooth");
        abcd.add("YouTube");
        abcd.add("Keep");
        abcd.add("Mail");
        abcd.add("Telegram");
        abcd.add("TikTok");
        abcd.add("Dribble");


        abcdImage.add(R.drawable.facebook);
        abcdImage.add(R.drawable.wa);
        abcdImage.add(R.drawable.insta);
        abcdImage.add(R.drawable.twit);
        abcdImage.add(R.drawable.message);
        abcdImage.add(R.drawable.blu);
        abcdImage.add(R.drawable.youtubr);
        abcdImage.add(R.drawable.keep);
        abcdImage.add(R.drawable.mail);
        abcdImage.add(R.drawable.telegram);
        abcdImage.add(R.drawable.tiktok);
        abcdImage.add(R.drawable.dribble);


        adapter = new adaptersharebutton(this, abcd, abcdImage);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        String nama = getIntent().getStringExtra("nama");
        ImageView butonbck = findViewById(R.id.back);
        TextView textViewJudul = findViewById(R.id.pp);
        textViewJudul.setText(nama);

        bck = findViewById(R.id.back);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sharebutton.this, activityreels.class);
                startActivity(intent);
            }
        });

    }
}
