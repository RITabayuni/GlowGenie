package com.example.glowgenie.community;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;


import com.example.glowgenie.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PostActivity extends AppCompatActivity {

    ImageView ivPost;
    ProgressBar progressBar;
    private Uri selectedUri;
    private static final int PICK_FILE = 1;
    UploadTask uploadTask;
    EditText etTitle, etDesc;
    Button btnChooseFile, btnUploadFile;
    ImageView btnClose;
    VideoView vvPost;
    String url, name;
    StorageReference storageReference;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://glowgenie-a6796-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference db1, db2, db3;
    MediaController mediaController;
    String type;
    PostMember postMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaController = new MediaController(this);
        postMember = new PostMember();

        progressBar = findViewById(R.id.pb_post);
        ivPost = findViewById(R.id.iv_post);
        vvPost = findViewById(R.id.vv_post);
        btnChooseFile = findViewById(R.id.btn_chooseFile_post);
        btnUploadFile = findViewById(R.id.btn_uploadfile_post);
        etTitle = findViewById(R.id.et_title_post);
        etDesc = findViewById(R.id.et_desc_post);
        btnClose = findViewById(R.id.btn_close);

        btnClose.setOnClickListener(v -> finish());


        storageReference = FirebaseStorage.getInstance().getReference("User posts");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String currentUid = user.getUid();
            db1 = database.getReference("All images").child(currentUid);
            db2 = database.getReference("All videos").child(currentUid);
            db3 = database.getReference("All posts");
        } else {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
            finish();
        }


        btnUploadFile.setOnClickListener(v->{
            Dopost();
        });
        btnChooseFile.setOnClickListener(v->{
            chooseImage();
        });
    }

    private void chooseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/* video/*");
        startActivityForResult(intent,PICK_FILE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE || requestCode == RESULT_OK || data != null || data.getData() != null){
            selectedUri = data.getData();
            if (selectedUri.toString().contains("image")){
                Picasso.get().load(selectedUri).into(ivPost);
                ivPost.setVisibility(View.VISIBLE);
                vvPost.setVisibility(View.INVISIBLE);
                type = "iv";
            } else if (selectedUri.toString().contains("video")) {
                vvPost.setMediaController(mediaController);
                vvPost.setVisibility(View.VISIBLE);
                ivPost.setVisibility(View.INVISIBLE);
                vvPost.setVideoURI(selectedUri);
                vvPost.start();
                type = "vv";
            } else {
                Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private  String getFileExt(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentUid = user.getUid();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference documentReference = db.collection("user").document(currentUid);

        documentReference.get().addOnCompleteListener((task)-> {
            if (task.getResult().exists()){
                name = task.getResult().getString("name");
                url = task.getResult().getString("url");
            } else {
                Toast.makeText(PostActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void Dopost() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
            return;
        }

        String currentUid = user.getUid();
        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();

        Calendar cdate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-yyyy");
        final String saveDate = currentDate.format(cdate.getTime());

        Calendar ctime = Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
        final String saveTime = currentTime.format(ctime.getTime());

        String time = saveDate + ":" + saveTime;

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(desc) || selectedUri != null){
            final StorageReference reference = storageReference.child(System.currentTimeMillis()+ "."+getFileExt(selectedUri));
            uploadTask = reference.putFile(selectedUri);

            Task<Uri> urlTask = uploadTask.continueWithTask((task)->{
                if (!task.isSuccessful()){
                    throw  task.getException();
                }
                return reference.getDownloadUrl();
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){
                        Uri downloadUri = task.getResult();

                        if (type.equals("iv")){
                            postMember.setTitle(title);
                            postMember.setDesc(desc);
                            postMember.setName(name);
                            postMember.setPostUri(downloadUri.toString());
                            postMember.setTime(time);
                            postMember.setUid(currentUid);
                            postMember.setUrl(url);
                            postMember.setType("iv");

                            //Untuk Image ya kack
                            String id = db1.push().getKey();
                            db1.child(id).setValue(postMember);

                            //Ini untuk image sama video
                            String id1 = db3.push().getKey();
                            db3.child(id1).setValue(postMember);

                            Toast.makeText(PostActivity.this, "Post Uploaded", Toast.LENGTH_SHORT).show();

                        } else if (type.equals("vv")) {
                            postMember.setTitle(title);
                            postMember.setDesc(desc);
                            postMember.setName(name);
                            postMember.setPostUri(downloadUri.toString());
                            postMember.setTime(time);
                            postMember.setUid(currentUid);
                            postMember.setUrl(url);
                            postMember.setType("vv");

                            //Untuk Image ya kack
                            String id3 = db2.push().getKey();
                            db1.child(id3).setValue(postMember);

                            //Ini untuk image sama video
                            String id4 = db3.push().getKey();
                            db3.child(id4).setValue(postMember);

                            Toast.makeText(PostActivity.this, "Post Uploaded", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(PostActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        } else {
            Toast.makeText(this, "Please fill all Fields", Toast.LENGTH_SHORT).show();
        }
    }

}