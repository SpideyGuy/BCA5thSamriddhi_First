package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView rv;

    RecyclerAdapter rvAdapter;

    ArrayList<StudentRecord> studentRecords;

    DatabaseHelper dbHelper;

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rv = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this);

        rv.setLayoutManager(layoutManager);

        studentRecords = new ArrayList<>();

        dbHelper = new DatabaseHelper(this);

        students = new ArrayList<>();

        students.addAll(dbHelper.getStudents());

        StudentRecord student1 = new StudentRecord(
                "Aanchal Neupane",
                "Aanchal",
                "9841123456",
                "https://scontent.fktm8-1.fna.fbcdn.net/v/t39.30808-6/275688135_692647975488029_8261492751721297078_n.jpg?_nc_cat=106&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=OrBVNBXtuTAAX-NZtJn&_nc_ht=scontent.fktm8-1.fna&oh=00_AT__GiOmxOYulLleq2oJiGXKVA_vJNJaDpmqGGTsWTMU_w&oe=626C1C9E");

        StudentRecord student2 = new StudentRecord(
                "Rishav Balla",
                "Rishav",
                "9841123457",
                "https://scontent.fktm8-1.fna.fbcdn.net/v/t39.30808-6/262646346_4676601509070671_229867944808415827_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=r69AwG-WXqoAX8ycugw&_nc_ht=scontent.fktm8-1.fna&oh=00_AT-WegKLszVTZvkxLUXsv7O_tYHljrguJfjcr-nmAFAeQQ&oe=626C0E47");

        StudentRecord student3 = new StudentRecord(
                "Prabal Bajracharya",
                "Prabal",
                "9841123458",
                "https://scontent.fktm8-1.fna.fbcdn.net/v/t39.30808-6/273633463_2038760446287164_3531720897313104245_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=SBg4zPGd0DQAX-RHriX&_nc_ht=scontent.fktm8-1.fna&oh=00_AT8gd7it2uB3tWFkcYHqq2qFtpCnz9BMhS_YsR-UvgqwCg&oe=626CF5B4");

        StudentRecord student4 = new StudentRecord(
                "Ashmita",
                "Ashmita",
                "9841123459",
                "https://scontent.fktm8-1.fna.fbcdn.net/v/t1.6435-9/204959884_1171027939988440_2916660421483836620_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=e3f864&_nc_ohc=-L5JbhXlGPAAX-yELaL&_nc_ht=scontent.fktm8-1.fna&oh=00_AT_71giWZmlIygPeTH4vnwWVCBVONO_UE64vYJmerDHBFA&oe=628B0DE6");

        studentRecords.add(student1);
        studentRecords.add(student2);
        studentRecords.add(student3);
        studentRecords.add(student4);

        rvAdapter = new RecyclerAdapter(this, students);

        rv.setAdapter(rvAdapter);


    }
}