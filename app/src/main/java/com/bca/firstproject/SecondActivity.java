package com.bca.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnClick;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnClick = (Button) findViewById(R.id.btn_click_1);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        Toast.makeText(this,"Hello I am " + name, Toast.LENGTH_LONG).show();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendingIntent = new Intent();
                sendingIntent.putExtra("name", "Ramesh");
                setResult(10, sendingIntent);
                finish();
            }
        });
    }
}
