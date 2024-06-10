package com.example.glowgenie.shop;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;
import com.example.glowgenie.booking.DoctorAdapter;
import com.example.glowgenie.calendar.CalenderAdapter;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private PopularAdapter shopAdapter;
    private List<PopularDomain> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop2);

        List<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Skintific Moisturizer","Tangerang Selatan",139000, R.drawable.product5));
        items.add(new PopularDomain("Facetology Sunscreen","DKI Jakarta",200000, R.drawable.product4));
        items.add(new PopularDomain("Somethinc Serum","Tangerang Selatan",300000, R.drawable.product3));

        recyclerView = findViewById(R.id.Recycler_View1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PopularAdapter(items, getApplicationContext()));

    }

    @Override
    public void onClick(View v) {

    }
}