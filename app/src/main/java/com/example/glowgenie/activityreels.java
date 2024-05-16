package com.example.glowgenie;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class activityreels extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<Video> videoList;
    private VideoAdapter adapter;
    private ImageView profil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reels);

        profil = findViewById(R.id.profil);
        videoList = new ArrayList<>();
        viewPager2 = findViewById(R.id.viewPager2);

        videoList.add(new Video("android.resource://"+ getPackageName() + "/" + R.raw.a , "Anita Ang" , "descc" ));
        videoList.add(new Video("android.resource://"+ getPackageName() + "/" + R.raw.b , "Anita Ang" , "descc" ));
        videoList.add(new Video("android.resource://"+ getPackageName() + "/" + R.raw.c , "Anita Ang" , "descc" ));
        videoList.add(new Video("android.resource://"+ getPackageName() + "/" + R.raw.d , "Kamila Jaidi" , "descc" ));
        videoList.add(new Video("android.resource://"+ getPackageName() + "/" + R.raw.e , "Kamila Jaidi" , "descc" ));

        adapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(adapter);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityreels.this, sideprofil.class);
                String nama = videoList.get(viewPager2.getCurrentItem()).getTitle();
                intent.putExtra("nama", nama);
                startActivity(intent);
            }
        });

        final ImageView flImageView = findViewById(R.id.fl);
        final ImageView fybImageView = findViewById(R.id.fyb);

        final int originalFlImageResource = R.drawable.relfl;
        final int originalFybImageResource = R.drawable.relfyb;

        flImageView.setOnClickListener(new View.OnClickListener() {
            boolean isFlClicked = false;

            @Override
            public void onClick(View v) {
                if (isFlClicked) {
                    flImageView.setImageResource(originalFlImageResource);
                    fybImageView.setImageResource(originalFybImageResource);
                } else {
                    flImageView.setImageResource(R.drawable.relflb);
                    fybImageView.setImageResource(R.drawable.relfy);
                }
                isFlClicked = !isFlClicked;
            }
        });

        fybImageView.setOnClickListener(new View.OnClickListener() {
            boolean isFybClicked = false;

            @Override
            public void onClick(View v) {
                if (isFybClicked) {
                    fybImageView.setImageResource(originalFybImageResource);
                    flImageView.setImageResource(originalFlImageResource);
                } else {
                    fybImageView.setImageResource(R.drawable.relfy);
                    flImageView.setImageResource(R.drawable.relflb);
                }
                isFybClicked = !isFybClicked;
            }
        });

    }
}