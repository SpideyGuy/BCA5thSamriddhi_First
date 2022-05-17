package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParseActivity extends AppCompatActivity {

    ListView lvStudents;

    ArrayList<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparse);

        lvStudents = (ListView) findViewById(R.id.lv_students);

        students = new ArrayList<>();

        String json_string ="[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Aanchal\",\n" +
                "        \"color\": \"Red\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Ashmita\",\n" +
                "        \"color\": \"Blue\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"Bikash\",\n" +
                "        \"color\": \"Green\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"name\": \"Anil\",\n" +
                "        \"color\": \"Orange\"\n" +
                "    }\n" +
                "]";

        try {
            JSONArray jsonArray = new JSONArray(json_string);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String temp_name = jsonObject.getString("name");
                if(temp_name != ""){
                    students.add(temp_name);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter nameAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, students);

        lvStudents.setAdapter(nameAdapter);


    }
}