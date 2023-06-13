package com.project.budgetingapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class monthly extends AppCompatActivity {

    TextView bulan,sisa,sisabulan;
    dbhelper db;
    EditText edit;
    Button button;

    int sisajumlah,bulanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);
        bulan = findViewById(R.id.bulan);
        sisa = findViewById(R.id.sisa);
        sisabulan=findViewById(R.id.sisa2);
        db = new dbhelper(this);
        bulanan = db.ambilbulan();

        bulan.setText("Rp. "+String.valueOf(bulanan));
        edit = findViewById(R.id.editbulanan);
        button = findViewById(R.id.button);
        sisajumlah = db.ambilTotal();
        sisa.setText("Rp. "+String.valueOf(sisajumlah));
        sisabulan.setText("Rp. "+String.valueOf(bulanan-sisajumlah));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.editbulanan(Integer.parseInt(String.valueOf(edit.getText())));
            }
        });



    }
}