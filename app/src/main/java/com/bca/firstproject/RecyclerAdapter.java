package com.bca.firstproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<
        RecyclerAdapter.ViewHolder>{

    Activity ctx;
    ArrayList<StudentRecord> stdRecords;

    public RecyclerAdapter(Activity context,
                           ArrayList<StudentRecord> studentRecords){
        this.ctx = context;
        this.stdRecords = studentRecords;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                         int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View item = inflater.inflate(R.layout.recycler_item,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder,
                                 int position) {

        holder.name.setText(stdRecords.get(position).getTitle());
        holder.nickname.setText(stdRecords.get(position).getNickname());

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:"+
                                stdRecords.get(position).getPhone()));
                ctx.startActivity(callIntent);
            }
        });

        Picasso.get().
                load(stdRecords.get(position).getPhoto()).
                into(holder.photo);

//        try {
//            URL url = new URL(
//                    stdRecords.get(position).getPhoto());
//            Bitmap bmp = BitmapFactory.decodeStream(
//                    url.openConnection().getInputStream());
//            holder.photo.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public int getItemCount() {
        return stdRecords.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView photo;
        TextView name, nickname;
        Button call;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.iv_rv);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            call = (Button) itemView.findViewById(R.id.btn_call);
        }
    }

}
