package com.example.glowgenie;

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

public class CommunityList extends AppCompatActivity implements View.OnClickListener {

    Button join1, join2, join3, join4;
    TextView judulContent1, judulContent2, judulContent3, judulContent4;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        join1 = findViewById(R.id.join);
        join2 = findViewById(R.id.join2);
        join3 = findViewById(R.id.join3);
        join4 = findViewById(R.id.join4);
        judulContent1 = findViewById(R.id.judulContent);
        judulContent2 = findViewById(R.id.judulContent2);
        judulContent3 = findViewById(R.id.judulContent3);
        judulContent4 = findViewById(R.id.judulContent4);
        back = findViewById(R.id.back);

        join1.setOnClickListener(this);
        join2.setOnClickListener(this);
        join3.setOnClickListener(this);
        join4.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == join1.getId()){
            String judul1 = judulContent1.getText().toString();
            Intent intent = new Intent(CommunityList.this, CommunityDetail.class);
            intent.putExtra("judul", judul1);
            startActivity(intent);
        } else if (v.getId() == join2.getId()){
            String judul2 = judulContent2.getText().toString();
            Intent intent = new Intent(CommunityList.this, CommunityDetail.class);
            intent.putExtra("judul", judul2);
            startActivity(intent);
        } else if (v.getId() == join3.getId()){
            String judul3 = judulContent3.getText().toString();
            Intent intent = new Intent(CommunityList.this, CommunityDetail.class);
            intent.putExtra("judul", judul3);
            startActivity(intent);
        } else if (v.getId() == join4.getId()){
            String judul4 = judulContent4.getText().toString();
            Intent intent = new Intent(CommunityList.this, CommunityDetail.class);
            intent.putExtra("judul", judul4);
            startActivity(intent);
        } else if(v.getId() == back.getId()){
            back.setOnClickListener(view -> this.finish());
        }
    }
}