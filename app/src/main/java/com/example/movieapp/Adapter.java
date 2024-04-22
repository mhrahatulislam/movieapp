package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.CustomViewHolder> {


    private Context context;
    private List<ModelClass> modelClassList;

    public Adapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.design,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        Glide.with(context).load(modelClassList.get(position).getPoster()).into(holder.imageView);
        holder.Title.setText(modelClassList.get(position).getTitle());
        holder.Year.setText(modelClassList.get(position).getYear());
        holder.Runtime.setText(modelClassList.get(position).getRuntime());

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView Title, Year,Runtime;
        ImageView imageView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            Title=itemView.findViewById(R.id.tvMovie_name);
            Year=itemView.findViewById(R.id.tvYear);
            Runtime=itemView.findViewById(R.id.tvRuntime);
            imageView=itemView.findViewById(R.id.imageView);

        }
    }
}
