package com.project.budgetingapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recview;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new dbhelper(this);

        recview = findViewById(R.id.recview);

        parentadapter parent = new parentadapter(ParentItemList2(),this);
        recview.setAdapter(parent);
        recview.setLayoutManager(new LinearLayoutManager(this));

        Button button = findViewById(R.id.tambahba);
        Button but = findViewById(R.id.pindah);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tambah.class);
                startActivity(intent);
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, monthly.class);
                startActivity(intent);
            }
        });

    }

    private List<parent2> ParentItemList2(){
        List<parent2> itemList2 = new ArrayList<>();

        parent2 item = new parent2("Grocery",db.ChildItemList("Grocery"), db.child("Grocery"),db.ambiltanggal("Grocery"),"Grocery");
        itemList2.add(item);
        parent2 item1 = new parent2("Transport",db.ChildItemList("Transport"), db.child("Transport"),db.ambiltanggal("Transport"),"Transport");
        itemList2.add(item1);
        parent2 item2 = new parent2("Entertainment",db.ChildItemList("Entertainment"), db.child("Entertainment"),db.ambiltanggal("Entertainment"),"Entertainment");
        itemList2.add(item2);
        parent2 item3 = new parent2("Saving",db.ChildItemList("Saving"), db.child("Saving"),db.ambiltanggal("Saving"),"Saving");
        itemList2.add(item3);

        return itemList2;
    }

}