package com.example.glowgenie.community;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

public class CommunityDetail extends AppCompatActivity {

    TextView namaCommunity, tvDesc;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_detail);


        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String desc = intent.getStringExtra("desc");

        namaCommunity = findViewById(R.id.judul);
        namaCommunity.setText(judul);
        tvDesc = findViewById(R.id.desc);
        tvDesc.setText(desc);

        back = findViewById(R.id.back);
        back.setOnClickListener(view -> this.finish());
    }
}