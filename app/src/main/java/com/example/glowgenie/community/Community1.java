package com.example.glowgenie.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.glowgenie.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Community1 extends AppCompatActivity implements View.OnClickListener{

    TextView halo, seeMore;
    FirebaseAuth mAuth;
    Button join1, join2;

    ImageView home;
    TextView judulContent1, judulContent2;
    TextView desc1, desc2;
    RelativeLayout community1, community2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community1);

        mAuth = FirebaseAuth.getInstance();

        halo = findViewById(R.id.halo);
        seeMore = findViewById(R.id.seeMore);
        join1 = findViewById(R.id.join);
        join2 = findViewById(R.id.join2);
        judulContent1 = findViewById(R.id.judulContent);
        judulContent2 = findViewById(R.id.judulContent2);
        desc1 = findViewById(R.id.subContent);
        desc2 = findViewById(R.id.subContent2);
        home = findViewById(R.id.home);

        community1 = findViewById(R.id.community1);
        community2 = findViewById(R.id.community2);

        seeMore.setOnClickListener(this);
        join1.setOnClickListener(this);
        join2.setOnClickListener(this);
        community1.setOnClickListener(this);
        community2.setOnClickListener(this);
        home.setOnClickListener(view -> this.finish());

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            if (name != null) {
                halo.setText("Halo, " + name + "!");
            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == seeMore.getId()){
            Intent intent = new Intent(Community1.this, CommunityList.class);
            startActivity(intent);
        }
        if (v.getId() == join1.getId() || v.getId() == community1.getId()){
            String judul = judulContent1.getText().toString();
            String desc = desc1.getText().toString();
            Intent intent = new Intent(Community1.this, CommunityDetail.class);
            intent.putExtra("judul", judul);
            intent.putExtra("desc", desc);
            startActivity(intent);
        } else if (v.getId() == join2.getId() || v.getId() == community2.getId()){
            String judul2 = judulContent2.getText().toString();
            Intent intent = new Intent(Community1.this, CommunityDetail.class);
            intent.putExtra("judul", judul2);
            String desc = desc2.getText().toString();
            intent.putExtra("desc", desc);
            startActivity(intent);
        }
    }
}