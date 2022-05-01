package com.bca.firstproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<StudentRecord> {


    public CustomAdapter(@NonNull Activity context, ArrayList<StudentRecord> studentRecords) {
        super(context,0, studentRecords);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View individual_row = convertView;

        if (individual_row == null) {
            individual_row = LayoutInflater.from(getContext()).inflate(R.layout.listview_row,parent,false);
        }

        StudentRecord studentRecord = getItem(position);

//        ImageView imageView = (ImageView) individual_row.findViewById(R.id.iv_row);
        TextView title = (TextView) individual_row.findViewById(R.id.tv_title);
        TextView date = (TextView) individual_row.findViewById(R.id.tv_date);
        TextView description = (TextView) individual_row.findViewById(R.id.tv_description);

//        imageView.setImageDrawable(R.drawable.ic_launcher_background);
        title.setText(studentRecord.getTitle());
        date.setText(studentRecord.getDate());
        description.setText(studentRecord.getDescription());

        return individual_row;
    }
}
