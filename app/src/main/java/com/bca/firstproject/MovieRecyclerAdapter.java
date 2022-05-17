package com.bca.firstproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<
        MovieRecyclerAdapter.ViewHolder>{

    Activity ctx;
    ArrayList<Movies> moviesRecords;

    public MovieRecyclerAdapter(Activity context,
                           ArrayList<Movies> moviesRecords){
        this.ctx = context;
        this.moviesRecords = moviesRecords;
    }

    @NonNull
    @Override
    public MovieRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View item = inflater.inflate(R.layout.movie_recycler_item,
                parent,false);
        MovieRecyclerAdapter.ViewHolder viewHolder = new MovieRecyclerAdapter.ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerAdapter.ViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {

        holder.title.setText(moviesRecords.get(position).getTitle());
        holder.summary.setText(moviesRecords.get(position).getSummary());
        holder.rating.setText(moviesRecords.get(position).getRating());

        Picasso.get().
                load(moviesRecords.get(position).getImage()).
                into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return moviesRecords.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cover;
        TextView title, summary, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.iv_movie);
            title = (TextView) itemView.findViewById(R.id.tv_title_movie);
            summary = (TextView) itemView.findViewById(R.id.tv_summary_movie);
            rating = (TextView) itemView.findViewById(R.id.tv_rating_movie);
        }
    }

}
