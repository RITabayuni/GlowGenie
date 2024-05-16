package com.example.glowgenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.community.Community1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout community;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        community = findViewById(R.id.community);
        community.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == community.getId()){
            Intent intent = new Intent(MainActivity.this, Community1.class);
            startActivity(intent);
        }
    }
}