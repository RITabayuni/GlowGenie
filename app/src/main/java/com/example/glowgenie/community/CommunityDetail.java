package com.example.glowgenie.community;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class CommunityDetail extends AppCompatActivity {

    TextView namaCommunity, tvDesc;
    ImageView back;
    private RecyclerView recyclerView;
    private DetailAdapter adapter;
    private List<Post> postList;
    Button btnMember;
    boolean isMember = false;

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

        btnMember = findViewById(R.id.btnMember);
        updateMember();
        btnMember.setOnClickListener(v->{
            if (isMember) {
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to leave this community?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            isMember = false;
                            updateMember();
                            adapter.notifyDataSetChanged();
                        })
                        .setNegativeButton("No", null)
                        .show();
            } else {
                isMember = true;
                updateMember();
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView = findViewById(R.id.recycler_post);
        recyclerView.setHasFixedSize(true);



        postList = new ArrayList<>();
        postList.add(new Post("Drop Review Avoskin", "Buat kalian yang pake avoskin, drop review kalian di comment dong. Penasaran banget mau cobaaa", R.drawable.avoskin));
        postList.add(new Post("Spill Produk Mantap", "Aku rekomendasiin Avoskin buat kalian, ini tuh bagus banget ya Allah", R.drawable.avoskin));
        postList.add(new Post("HELP ME BRUNTUSAN", "HUHUHUHU HELP PLIS AKU BREAKOUT LAGIIIII. Saran Produk buat acne sensitive skin dongg guyss", R.drawable.acne_pic));

        adapter = new DetailAdapter(this, postList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CommunityDetail.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void updateMember(){
        if (isMember) {
            btnMember.setText("Member");
        } else {
            btnMember.setText("Join");
        }
    }
}