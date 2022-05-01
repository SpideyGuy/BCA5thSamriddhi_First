package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridExampleActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_example);

        gridView = (GridView) findViewById(R.id.gridView);

        String students[] = {"Anil", "Nishesh", "Ashmita", "Aanchal", "Sujit", "Bikash", "Anu", "Ajay", "Ayush"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.grid_items,
                R.id.tv_grid,
                students);

        gridView.setAdapter(adapter);

    }
}