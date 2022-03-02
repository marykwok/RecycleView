package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] items, desc;
    int[] img = {R.drawable.fries, R.drawable.nugs, R.drawable.bigMac};
    RecyclerView rcycv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing RecycleView and relevant variables
        items = getResources().getStringArray(R.array.items);
        desc = getResources().getStringArray(R.array.desc);
        rcycv = findViewById(rcycv.getId());
        MyAdapter adpt = new MyAdapter(this, items, desc, img);
    }
}