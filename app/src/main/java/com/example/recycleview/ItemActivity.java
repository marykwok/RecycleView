package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    ImageView img;
    TextView name, desc;
    String itemName, itemDesc;
    int itemImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        img = findViewById(R.id.itemImg);
        desc = findViewById(R.id.itemDesc);
        name = findViewById(R.id.itemName);
        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("img") &&
           getIntent().hasExtra("desc") &&
           getIntent().hasExtra("name")){
            itemImg = getIntent().getIntExtra("img", 1);
            itemName = getIntent().getStringExtra("name");
            itemDesc = getIntent().getStringExtra("desc");

        }else{
            Toast.makeText(this, "Error: No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        desc.setText(itemDesc);
        name.setText(itemName);
        img.setImageResource(itemImg);
    }
}