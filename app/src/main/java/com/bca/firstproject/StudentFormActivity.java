package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentFormActivity extends AppCompatActivity {

    EditText etName, etNickName, etPhone, etPhoto;
    Button btnRegister, btnView;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        etName = (EditText) findViewById(R.id.et_name);
        etNickName = (EditText) findViewById(R.id.et_nickname);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etPhoto = (EditText) findViewById(R.id.et_photo);

        btnRegister = (Button) findViewById(R.id.btn_register);

        btnView = (Button) findViewById(R.id.btn_view);

        dbHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = dbHelper.insertStudent(etName.getText().toString(),
                        etNickName.getText().toString(),
                        etPhone.getText().toString(),
                        etPhoto.getText().toString());
                if(id > 0){
                    Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(StudentFormActivity.this,
                                RecyclerActivity.class));
            }
        });

    }
}