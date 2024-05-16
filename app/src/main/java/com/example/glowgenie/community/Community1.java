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

import com.example.glowgenie.R;

public class Community1 extends AppCompatActivity implements View.OnClickListener{

    TextView seeMore;
    Button join1, join2;

    ImageView home;
    TextView judulContent1, judulContent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        seeMore = findViewById(R.id.seeMore);
        join1 = findViewById(R.id.join);
        join2 = findViewById(R.id.join2);
        judulContent1 = findViewById(R.id.judulContent);
        judulContent2 = findViewById(R.id.judulContent2);
        home = findViewById(R.id.home);

        seeMore.setOnClickListener(this);
        join1.setOnClickListener(this);
        join2.setOnClickListener(this);
        home.setOnClickListener(view -> this.finish());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == seeMore.getId()){
            Intent intent = new Intent(Community1.this, CommunityList.class);
            startActivity(intent);
        }
        if (v.getId() == join1.getId()){
            String judul1 = judulContent1.getText().toString();
            Intent intent = new Intent(Community1.this, CommunityDetail.class);
            intent.putExtra("judul", judul1);
            startActivity(intent);
        } else if (v.getId() == join2.getId()){
            String judul2 = judulContent2.getText().toString();
            Intent intent = new Intent(Community1.this, CommunityDetail.class);
            intent.putExtra("judul", judul2);
            startActivity(intent);
        }
    }
}