package com.example.glowgenie.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.ArrayList;
import java.util.List;

public class Calendar extends AppCompatActivity {
    private LinearLayout btn_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_layout = findViewById(R.id.btn_lay);
        btn_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calendar.this,Calendar2.class));
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Today", "Hydrating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Today", "Exfoliating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Today", "Skin Barrier Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Today", "Hydrating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CalenderAdapter(getApplicationContext(),items));
    }
}