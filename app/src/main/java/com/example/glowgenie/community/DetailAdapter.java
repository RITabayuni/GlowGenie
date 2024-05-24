package com.example.glowgenie.community;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder>{
    private List<Post> postList;
    private Context context;


    public DetailAdapter(Context context, List<Post> postList){
        this.context = context;
        this.postList= postList;
    }

    @NonNull
    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_community, parent, false);
        return new DetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder holder, int position){
        Post post = postList.get(position);
        holder.title.setText(post.getTitle());
        holder.content.setText(post.getContent());
        holder.imagePost.setImageResource(post.getImage());
    }

    @Override
    public  int getItemCount(){
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout post;
        TextView title, content;
        ImageView imagePost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.post);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            imagePost = itemView.findViewById(R.id.pictureContent);
        }

    }

}
