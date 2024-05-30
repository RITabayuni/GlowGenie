package com.example.glowgenie.community;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostMember> postList;
    private Context context;

    public PostAdapter(Context context, List<PostMember> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_community, parent, false);
        context = parent.getContext();
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostMember post = postList.get(position);

        holder.user.setText(post.getName());
        holder.time.setText(post.getTime());
        holder.title.setText(post.getTitle());
        holder.content.setText(post.getDesc());

        if (post.getType().equals("iv")) {
            Picasso.get().load(post.getPostUri()).into(holder.ivPost);
            holder.ivPost.setVisibility(View.VISIBLE);
        } else {
            holder.ivPost.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView user, time, title, content;
        ImageView ivPost, menu;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.user);
            time = itemView.findViewById(R.id.time);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            ivPost = itemView.findViewById(R.id.pictureContent);
            menu = itemView.findViewById(R.id.menu);
        }
    }
}
