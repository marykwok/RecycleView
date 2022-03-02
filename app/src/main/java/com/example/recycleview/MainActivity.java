package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] items, desc;
    int[] img = {R.drawable.bigmac_combo,  R.drawable.nuggets_combo, R.drawable.mcmuffine_combo};
    RecyclerView rcycv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing RecycleView and relevant variables
        items = getResources().getStringArray(R.array.items);
        desc = getResources().getStringArray(R.array.desc);
        rcycv = findViewById(R.id.rcycv);
        MyAdapter adpt = new MyAdapter(this, items, desc, img);
        rcycv.setAdapter(adpt);
        rcycv.setLayoutManager(new LinearLayoutManager(this));
    }
}