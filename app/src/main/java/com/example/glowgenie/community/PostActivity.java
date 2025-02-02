// PostActivity.java
package com.example.glowgenie.community;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.glowgenie.R;
import com.example.glowgenie.community.Post;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class PostActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;
    private ImageView ivPost, btnClose;
    private EditText etTitle, etDesc;
    private ProgressBar progressBar;
    private Button btnChooseFile, btnUploadFile;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private static final String TAG = "PostActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ivPost = findViewById(R.id.iv_post);
        etTitle = findViewById(R.id.et_title_post);
        etDesc = findViewById(R.id.et_desc_post);
        progressBar = findViewById(R.id.pb_post);
        btnChooseFile = findViewById(R.id.btn_chooseFile_post);
        btnUploadFile = findViewById(R.id.btn_uploadfile_post);
        btnClose = findViewById(R.id.btn_close);

        btnClose.setOnClickListener(v->finish());

        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        databaseReference = FirebaseDatabase.getInstance("https://glowgenie-a6796-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("posts");
        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        if (intent.hasExtra("postId")) {
            String postId = intent.getStringExtra("postId");
            String imageUrl = intent.getStringExtra("image");
            Picasso.get().load(imageUrl).into(ivPost);
            ivPost.setImageURI(Uri.parse(imageUrl));
            etTitle.setText(intent.getStringExtra("title"));
            etDesc.setText(intent.getStringExtra("desc"));
            btnUploadFile.setText("Edit");
            btnUploadFile.setOnClickListener(v -> updatePost(postId));
        } else {
            btnUploadFile.setOnClickListener(v -> uploadFile());
        }
        btnChooseFile.setOnClickListener(v->openFileChooser());
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();
            ivPost.setImageURI(mImageUri);
        }
    }

    private void uploadFile() {
        final String title = etTitle.getText().toString().trim();
        final String desc = etDesc.getText().toString().trim();
        if (title.isEmpty() || desc.isEmpty()) {
            Toast.makeText(this, "Title and Description cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mImageUri == null) {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        final StorageReference fileReference = storageReference.child(System.currentTimeMillis() + ".jpg");
        fileReference.putFile(mImageUri)
                .addOnSuccessListener(taskSnapshot -> fileReference.getDownloadUrl().addOnSuccessListener(uri -> {
                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    if (currentUser != null) {
                        String userName = currentUser.getDisplayName();
                        String userProfileUrl = currentUser.getPhotoUrl() != null ? currentUser.getPhotoUrl().toString() : "";
                        String userId = currentUser.getUid();
                        String postId = databaseReference.push().getKey();
                        Post post = new Post(postId, title, desc, uri.toString(), userName, userProfileUrl, System.currentTimeMillis(), userId);
                        databaseReference.child(postId).setValue(post).addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(PostActivity.this, "Post uploaded", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(PostActivity.this, "Failed to upload post" , Toast.LENGTH_SHORT).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        });
                    } else {
                        Toast.makeText(PostActivity.this, "User not logged in", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }))
                .addOnFailureListener(e -> {
                    Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                });
    }
    private void updatePost(String postId) {
        final String title = etTitle.getText().toString().trim();
        final String desc = etDesc.getText().toString().trim();
        if (title.isEmpty() || desc.isEmpty()) {
            Toast.makeText(this, "Title and Description cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mImageUri == null) {
            databaseReference.child(postId).child("title").setValue(title);
            databaseReference.child(postId).child("desc").setValue(desc);
            Toast.makeText(this, "Post updated", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        final StorageReference fileReference = storageReference.child(System.currentTimeMillis() + ".jpg");
        fileReference.putFile(mImageUri)
                .addOnSuccessListener(taskSnapshot -> fileReference.getDownloadUrl().addOnSuccessListener(uri -> {
                    Toast.makeText(PostActivity.this, "Post ID untuk edit: " + postId, Toast.LENGTH_SHORT).show();
                    databaseReference.child(postId).child("title").setValue(title);
                    databaseReference.child(postId).child("desc").setValue(desc);
                    databaseReference.child(postId).child("imageUrl").setValue(uri.toString());
                    Toast.makeText(PostActivity.this, "Post updated", Toast.LENGTH_SHORT).show();
                    finish();
                }))
                .addOnFailureListener(e -> {
                    Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                });
    }

}
