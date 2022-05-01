package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewExample extends AppCompatActivity {

    ListView listViewStudents;

    ArrayList<StudentRecord> studentRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_example);

        listViewStudents = (ListView) findViewById(R.id.list_custom_data);

        studentRecords = new ArrayList<>();

        StudentRecord student1 = new StudentRecord("Ram Krishna", "2020", "Hi i am ram krishna. Friends call me Ram");
        StudentRecord student2 = new StudentRecord("Ashmita", "2019", "Hi i am Ashmita. Friends call me Ashmita");

        StudentRecord student3 = new StudentRecord();
        student3.setTitle("Anil");
        student3.setDate("2021");
        student3.setDescription("Hi this is me Anil from Kathmandu");

        studentRecords.add(student1);
        studentRecords.add(student2);
        studentRecords.add(student3);

        CustomAdapter customAdapter = new CustomAdapter(this, studentRecords);

        listViewStudents.setAdapter(customAdapter);


    }
}