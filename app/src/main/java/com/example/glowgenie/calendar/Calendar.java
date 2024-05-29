package com.example.glowgenie.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.MainActivity;
import com.example.glowgenie.R;

import java.util.ArrayList;
import java.util.List;

public class Calendar extends AppCompatActivity implements View.OnClickListener{
    LinearLayout Day5;
    ImageView Back;
    TextView Bulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);

        Day5 = findViewById(R.id.day5);
        Back = findViewById(R.id.back);
        Bulan = findViewById(R.id.bulan);

        Day5.setOnClickListener(this);
        Back.setOnClickListener(this);
        Bulan.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Today", "Hydrating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Tomorrow", "Exfoliating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Wednesday", "Skin Barrier Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Thursday", "Hydrating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Friday", "Hydrating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Tomorrow", "Exfoliating Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));
        items.add(new Item("Wednesday", "Skin Barrier Day", "Face Wash \n Toner \n Serum \n Moisturizer \n Sunscreen", "Cleansing Oil \n FaceWash \n Toner \n Moisturizer"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CalenderAdapter(getApplicationContext(),items));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == Day5.getId()) {
            Intent intent = new Intent(Calendar.this, Calendar2.class);
            startActivity(intent);
        } else if (v.getId() == Back.getId()) {
            Intent intent = new Intent(Calendar.this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == Bulan.getId()){
            String bulan = Bulan.getText().toString();
            Intent intent =  new Intent(Calendar.this, Month.class);
            intent.putExtra("Month", bulan);
            startActivity(intent);
        }
    }
}