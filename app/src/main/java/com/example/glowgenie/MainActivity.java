package com.example.glowgenie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.calendar.Calendar;
import com.example.glowgenie.community.Community1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout community;
    TextView seem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        community = findViewById(R.id.community);
        community.setOnClickListener(this);

        seem = findViewById(R.id.seeMore);
        seem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == community.getId()){
            Intent intent = new Intent(MainActivity.this, Community1.class);
            startActivity(intent);
        }

        if (v.getId() == seem.getId()) {
            Intent intent = new Intent(MainActivity.this, Calendar.class);
            startActivity(intent);
        }
    }

}