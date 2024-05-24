package com.example.glowgenie.community;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.ArrayList;
import java.util.List;

public class CommunityList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommunityAdapter adapter;
    private List<Community> communityList;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_list);

        recyclerView = findViewById(R.id.recycler_community);
        recyclerView.setHasFixedSize(true);

        back = findViewById(R.id.back);
        back.setOnClickListener(view -> finish());

        communityList = new ArrayList<>();
        communityList.add(new Community(R.drawable.display_com1, "Brightening Only", "Brightening your skin together"));
        communityList.add(new Community(R.drawable.display_com2, "Oily Skin", "Share with us your skin experiences"));
        communityList.add(new Community(R.drawable.display_com3, "Combi Skin", "Oily and dry skin community"));
        communityList.add(new Community(R.drawable.display_com4, "Dry Like Desert ", "Dry Skin? Come join us and talk"));
        communityList.add(new Community(R.drawable.display_com1, "FILKOM Bright", "Waduh anak FILKOM stress yh?"));
        communityList.add(new Community(R.drawable.display_com2, "Project PAM", "Avv community anak project PAM xixixi"));
        communityList.add(new Community(R.drawable.display_com3, "TI Skin", "BUKAN SKIN MOBILE LEGEND!"));
        communityList.add(new Community(R.drawable.display_com4, "UB Skin", "Anak UB? Gas Join rek"));

        adapter = new CommunityAdapter(this, communityList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CommunityList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}