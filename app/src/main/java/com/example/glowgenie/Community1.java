package com.example.glowgenie;

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

public class Community1 extends AppCompatActivity implements View.OnClickListener{

    TextView seeMore;
    Button join1, join2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        seeMore = findViewById(R.id.seeMore);
        join1 = findViewById(R.id.join);
        join2 = findViewById(R.id.join2);

        seeMore.setOnClickListener(this);
        join1.setOnClickListener(this);
        join2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == seeMore.getId()){
            Intent intent = new Intent(Community1.this, CommunityList.class);
            startActivity(intent);
        }

        if (v.getId() == join1.getId() || v.getId() == join2.getId()){
            Intent intent = new Intent(Community1.this, CommunityDetail.class);
            startActivity(intent);
        }
    }
}