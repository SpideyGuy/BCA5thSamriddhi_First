package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Chapter6Activity extends AppCompatActivity {

    ListView lvGreetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter6);

        String[] greetings = {
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
                "Hi",
                "Hello",
                "Namaste",
                "Kemcho",
                "Namaskar",
                "Sanchai?",
                "aaramai?",
                "Ola",
                "Bonjour",
                "Tashi Dele",
        };

        lvGreetings = (ListView) findViewById(R.id.list_greetings);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, greetings);

        lvGreetings.setAdapter(adapter);

        lvGreetings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        Chapter6Activity.this,
                        greetings[i],
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}