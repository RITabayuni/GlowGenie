package com.example.glowgenie.community;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class CommunityDetail extends AppCompatActivity {

    TextView namaCommunity, tvDesc;
    ImageView back;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private DatabaseReference databaseReference;
    Button btnMember;
    boolean isMember = false;
    FloatingActionButton floatingActionButton;

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
        back.setOnClickListener(v -> this.finish());

        floatingActionButton = findViewById(R.id.add_btn);
        floatingActionButton.setOnClickListener(view->{
            Intent intentAdd = new Intent(CommunityDetail.this, PostActivity.class);
            startActivity(intentAdd);
        });

        btnMember = findViewById(R.id.btnMember);
        updateMember();
        btnMember.setOnClickListener(v->{
            if (isMember) {
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to leave this community?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            isMember = false;
                            updateMember();
                            postAdapter.notifyDataSetChanged();
                        })
                        .setNegativeButton("No", null)
                        .show();
            } else {
                isMember = true ;
                updateMember();
                postAdapter.notifyDataSetChanged();
            }
        });
        recyclerView = findViewById(R.id.recycler_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postList = new ArrayList<>();
        postAdapter = new PostAdapter(this, postList);
        recyclerView.setAdapter(postAdapter);

        databaseReference = FirebaseDatabase.getInstance("https://glowgenie-a6796-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("posts");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);
                }
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CommunityDetail.this, "Failed to load posts", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateMember(){
        if (isMember) {
            btnMember.setText("Member");
        } else {
            btnMember.setText("Join");
        }
    }
}