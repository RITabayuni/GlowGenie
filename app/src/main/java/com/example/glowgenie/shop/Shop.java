package com.example.glowgenie.shop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;
import com.example.glowgenie.booking.DoctorAdapter;
import com.example.glowgenie.calendar.CalenderAdapter;
import com.example.glowgenie.community.CommunityAdapter;
import com.example.glowgenie.community.CommunityList;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private PopularAdapter shopAdapter;
    private List<PopularDomain> productList;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop2);

        productList = new ArrayList<>();
        productList.add(new PopularDomain("Skintific Moisturizer","Tangerang Selatan",139000, R.drawable.product5));
        productList.add(new PopularDomain("Facetology Sunscreen","DKI Jakarta",200000, R.drawable.product4));
        productList.add(new PopularDomain("Somethinc Serum","Tangerang Selatan",300000, R.drawable.product3));

        recyclerView = findViewById(R.id.Recycler_View1);

        shopAdapter = new PopularAdapter(productList, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(shopAdapter);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

    }

    @Override
    public void onClick(View v) {

    }
}