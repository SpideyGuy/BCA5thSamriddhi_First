package com.bca.firstproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends Activity {

    RadioGroup rgColor;

    TextView tvColor, tvColorName;

    Spinner spStudent;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.spinner);

        spStudent = (Spinner) findViewById(R.id.sp_student);

        String students[] = {"Ram", "Shyam", "Hari", "Sita", "Gita", "Rita"};

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        students);

        spStudent.setAdapter(studentAdapter);

//        rgColor = (RadioGroup) findViewById(R.id.rg_color);
//
//        tvColor = (TextView) findViewById(R.id.tv_color);
//        tvColorName = (TextView) findViewById(R.id.tv_color_name);
//
//        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                RadioButton selectedRB = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
////                Toast.makeText(SplashActivity.this,"You Selected " + selectedRB.getText().toString(),Toast.LENGTH_SHORT).show();
////                tvColor.setTextColor(getApplicationContext().getColor(R.color.tvColor));
////                tvColor.setTextColor();
//                tvColorName.setText(selectedRB.getText().toString());
//            }
//        });

    }
}