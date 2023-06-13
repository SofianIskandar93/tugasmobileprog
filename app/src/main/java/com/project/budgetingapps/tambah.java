package com.project.budgetingapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class tambah extends AppCompatActivity {

    String nama;
    int jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);



        EditText text = findViewById(R.id.namapengeluaran);
        EditText jum = findViewById(R.id.editTextNumber);
        Button button = findViewById(R.id.tambah);



        dbhelper db;
        db = new dbhelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedValue = selectedRadioButton.getText().toString();
                nama = text.getText().toString();
                jumlah = Integer.parseInt(jum.getText().toString());

                db.tambah(selectedValue,nama,jumlah);
                Intent intent = new Intent(tambah.this, MainActivity.class);
                startActivity(intent);
            }
        });





    }
}