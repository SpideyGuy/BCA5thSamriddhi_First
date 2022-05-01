package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class CustomGridViewExample extends AppCompatActivity {

    GridView customGridView;

    ArrayList<StudentRecord> studentRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view_example);

        customGridView = (GridView) findViewById(R.id.custom_grid_view);

        studentRecords = new ArrayList<>();

        StudentRecord student1 = new StudentRecord("Ram Krishna", "2020", "Hi i am ram krishna. Friends call me Ram");
        StudentRecord student2 = new StudentRecord("Ashmita", "2019", "Hi i am Ashmita. Friends call me Ashmita");

        StudentRecord student3 = new StudentRecord();
        student3.setTitle("Anil");
        student3.setDate("2021");
        student3.setDescription("Hi this is me Anil from Kathmandu");

        StudentRecord student4 = new StudentRecord("Ayush", "2020", "Hi i am ayush. Friends call me Ayush");
        StudentRecord student5 = new StudentRecord("Aanchal", "2019", "Hi i am Aanchal. Friends call me Aanchal");

        studentRecords.add(student1);
        studentRecords.add(student2);
        studentRecords.add(student3);
        studentRecords.add(student4);
        studentRecords.add(student5);

        CustomAdapter customAdapter = new CustomAdapter(this,
                studentRecords);

        customGridView.setAdapter(customAdapter);

    }
}