package com.bca.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogExample extends AppCompatActivity implements View.OnClickListener{

    Button btnDialog, btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        btnDialog = (Button) findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(this);

        btnCalculator = (Button) findViewById(R.id.btnCalculator);
        btnCalculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnDialog:
                showAlertDialog();
                break;
            case R.id.btnCalculator:
                showCalculator();
                break;
            default:
                Toast.makeText(getApplicationContext(), "This is default layout", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showCalculator() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Demo Calculator");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.calculator_dialog, null);
        builder.setView(view);

        EditText etNumber1, etNumber2;
        Button btnAdd;
        TextView tvResult;

        etNumber1 = (EditText) view.findViewById(R.id.et_Number1);
        etNumber2 = (EditText) view.findViewById(R.id.et_Number2);
        btnAdd = (Button) view.findViewById(R.id.btn_Add);
        tvResult = (TextView) view.findViewById(R.id.tv_Result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(etNumber1.getText().toString());
                int num2 = Integer.parseInt(etNumber2.getText().toString());
                tvResult.setText("The Added value is: " +
                        String.valueOf(num1+num2));
            }
        });



        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Book?");
        builder.setMessage("Interested in book?");
        builder.setCancelable(false);
        builder.setPositiveButton("Huncha",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "vayo....dhanyabaad",
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hudaina",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "vayena..bye bye", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}