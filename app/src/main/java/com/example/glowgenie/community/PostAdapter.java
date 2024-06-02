package com.example.glowgenie.community;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;
    private Context context;
    private DatabaseReference databaseReference;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
        this.databaseReference = FirebaseDatabase.getInstance("https://glowgenie-a6796-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("posts");
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_community, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.tvTitle.setText(post.getTitle());
        holder.tvDesc.setText(post.getDesc());
        holder.tvUser.setText(post.getUser());
        if (post.getUserProfileUrl() != null && !post.getUserProfileUrl().isEmpty()) {
            Picasso.get().load(post.getUserProfileUrl()).transform(new CropCircleTransformation()).into(holder.profile);
        } else {
            holder.profile.setImageResource(R.drawable.ic_profile);
        }

        holder.tvTime.setText(formatTimestamp(post.getTimestamp()));
        Picasso.get().load(post.getImageUrl()).fit().centerCrop().into(holder.ivImage);

        holder.menu.setOnClickListener(v->{
            PopupMenu popupMenu = new PopupMenu(context, holder.menu);
            popupMenu.inflate(R.menu.menu_options);
            popupMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.action_edit) {
                    Intent intent = new Intent(context, PostActivity.class);
                    intent.putExtra("postId", post.getPostId());
                    intent.putExtra("image", post.getImageUrl());
                    intent.putExtra("title", post.getTitle());
                    intent.putExtra("desc", post.getDesc());
                    context.startActivity(intent);
                    return true;
                } else if (itemId == R.id.action_delete) {
                    deletePost(post.getPostId(), position);
                    return true;
                } else if (itemId == R.id.action_download) {
                    downloadImage(post.getImageUrl());
                    return true;
                } else {
                    return false;
                }

            });
            popupMenu.show();
        });
    }

    private void deletePost(String postId, int position) {
        new AlertDialog.Builder(context)
                .setTitle("Delete Post")
                .setMessage("Are you sure you want to delete this post?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    databaseReference.child(postId).removeValue()
                            .addOnSuccessListener(aVoid -> {
                                if (position >= 0 && position < postList.size()) {
                                    postList.remove(position);
                                }
                                Toast.makeText(context, "Post deleted", Toast.LENGTH_SHORT).show();
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(context, "Failed to delete post", Toast.LENGTH_SHORT).show();
                            });
                })
                .setNegativeButton("No", null)
                .show();
    }


    private void downloadImage(String imageUrl) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(imageUrl));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Downloading image...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(imageUrl, null, null));

        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

        Toast.makeText(context, "Download started", Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvDesc;
        public ImageView ivImage, profile;
        public ImageButton menu;
        public TextView tvTime, tvUser;

        public PostViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvDesc = itemView.findViewById(R.id.desc_post);
            ivImage = itemView.findViewById(R.id.iv_post);
            tvTime = itemView.findViewById(R.id.time);
            tvUser = itemView.findViewById(R.id.user);
            profile = itemView.findViewById(R.id.profile_user);
            menu = itemView.findViewById(R.id.more_options);
        }
    }

    private String formatTimestamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());
        return sdf.format(timestamp);
    }
}
