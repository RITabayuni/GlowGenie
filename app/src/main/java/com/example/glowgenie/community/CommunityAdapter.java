package com.example.glowgenie.community;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowgenie.R;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder> {
    private List<Community> communityList;
    private Context context;


    public CommunityAdapter(Context context, List<Community> communityList){
        this.context = context;
        this.communityList = communityList;
    }

    @NonNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community, parent, false);
        return new CommunityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityViewHolder holder, int position){
        int index1 = position * 2;
        int index2 = index1 + 1;

        if (index1 < communityList.size()) {
            Community community1 = communityList.get(index1);
            holder.ivCommunity1.setImageResource(community1.getImage());
            holder.judulContent.setText(community1.getTitle());
            holder.subContent.setText(community1.getDescription());

            holder.community1.setVisibility(View.VISIBLE);
            holder.community1.setOnClickListener(v->{
                Intent intent = new Intent(context, CommunityDetail.class);
                intent.putExtra("judul", community1.getTitle());
                intent.putExtra("desc", community1.getDescription());
                context.startActivity(intent);
            });
            holder.join1.setOnClickListener(v -> {
                Intent intent = new Intent(context, CommunityDetail.class);
                intent.putExtra("judul", community1.getTitle());
                intent.putExtra("desc", community1.getDescription());
                context.startActivity(intent);
            });
        } else {
            holder.community1.setVisibility(View.GONE);
        }

        if (index2 < communityList.size()) {
            Community community2 = communityList.get(index2);
            holder.ivCommunity2.setImageResource(community2.getImage());
            holder.judulContent2.setText(community2.getTitle());
            holder.subContent2.setText(community2.getDescription());

            holder.community2.setVisibility(View.VISIBLE);
            holder.community2.setOnClickListener(v->{
                Intent intent = new Intent(context, CommunityDetail.class);
                intent.putExtra("judul", community2.getTitle());
                intent.putExtra("desc", community2.getDescription());
                context.startActivity(intent);
            });
            holder.join2.setOnClickListener(v -> {
                Intent intent = new Intent(context, CommunityDetail.class);
                intent.putExtra("judul", community2.getTitle());
                intent.putExtra("desc", community2.getDescription());
                context.startActivity(intent);
            });
        } else {
            holder.community2.setVisibility(View.GONE);
        }
    }

    @Override
    public  int getItemCount(){
        return (communityList.size() + 1) / 2;
    }

    public class CommunityViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout community1, community2;
        ImageView ivCommunity1;
        ImageView ivCommunity2;
        TextView judulContent;
        TextView judulContent2;
        TextView subContent;
        TextView subContent2;
        Button join1;
        Button join2;

        public CommunityViewHolder(@NonNull View itemView) {
            super(itemView);
            community1 = itemView.findViewById(R.id.community1);
            community2 = itemView.findViewById(R.id.community2);
            ivCommunity1 = itemView.findViewById(R.id.ivCommunity1);
            ivCommunity2 = itemView.findViewById(R.id.ivCommunity2);
            judulContent = itemView.findViewById(R.id.judulContent);
            judulContent2 = itemView.findViewById(R.id.judulContent2);
            subContent = itemView.findViewById(R.id.subContent);
            subContent2 = itemView.findViewById(R.id.subContent2);
            join1 = itemView.findViewById(R.id.join);
            join2 = itemView.findViewById(R.id.join2);
        }

    }


}

