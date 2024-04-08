package com.example.glowgenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CommunityList extends AppCompatActivity implements View.OnClickListener {

    Button join1, join2, join3, join4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        join1 = findViewById(R.id.join);
        join2 = findViewById(R.id.join2);
        join3 = findViewById(R.id.join3);
        join4 = findViewById(R.id.join4);

        join1.setOnClickListener(this);
        join2.setOnClickListener(this);
        join3.setOnClickListener(this);
        join4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == join1.getId() || v.getId() == join2.getId() || v.getId() == join3.getId() || v.getId() == join4.getId()){
            Intent intent = new Intent(CommunityList.this, CommunityDetail.class);
            startActivity(intent);
        }
    }
}