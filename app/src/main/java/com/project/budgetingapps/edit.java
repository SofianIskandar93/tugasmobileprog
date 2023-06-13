package com.project.budgetingapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class edit extends AppCompatActivity {
    Button edit,hapus;
    String itemid;
    RadioButton groce,trans,ent,save;
    int id;
    String nama,date;
    EditText namapengeluaran,besar;
    int jumlah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit = findViewById(R.id.editbut);
        hapus = findViewById(R.id.delete);
        Bundle bundle = getIntent().getExtras();
        itemid = bundle.getString("itemid");
        id = bundle.getInt("id");

        groce = findViewById(R.id.groce);
        trans = findViewById(R.id.trans);
        ent = findViewById(R.id.ent);
        save = findViewById(R.id.save);
        dbhelper db;
        db = new dbhelper(this);

        switch (itemid){
            case("Grocery"):groce.setChecked(true);groce.setEnabled(false);trans.setEnabled(false);ent.setEnabled(false);save.setEnabled(false); break;
            case("Transport"):trans.setChecked(true);groce.setEnabled(false);trans.setEnabled(false);ent.setEnabled(false);save.setEnabled(false);; break;
            case("Entertainment"):ent.setChecked(true);groce.setEnabled(false);trans.setEnabled(false);ent.setEnabled(false);save.setEnabled(false);  break;
            case("Saving"):save.setChecked(true);groce.setEnabled(false);trans.setEnabled(false);ent.setEnabled(false);save.setEnabled(false);  break;
        }

        nama = db.ambildata(id,itemid);
        jumlah = db.ambiljumlah(id,itemid);
        date = db.ambildate(id,itemid);

        namapengeluaran = findViewById(R.id.namapengeluaran);
        besar = findViewById(R.id.besarpeng);

        namapengeluaran.setText(nama);
        besar.setText(String.valueOf(jumlah));

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.hapus(id,itemid);
                Intent intent = new Intent(edit.this, MainActivity.class);
                startActivity(intent);

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.edit(id,itemid,namapengeluaran.getText().toString(), Integer.parseInt(besar.getText().toString()));
                Intent intent = new Intent(edit.this, MainActivity.class);
                startActivity(intent);

            }
        });



    }
}