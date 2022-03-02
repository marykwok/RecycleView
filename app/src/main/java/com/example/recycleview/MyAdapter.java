package com.example.recycleview;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context ct;
    String[] items, desc;
    int[] img;

    public MyAdapter (Context ct, String[] items, String[] desc, int[] img){
        this.ct = ct;
        this.items = items;
        this.desc = desc;
        this.img = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder (@NonNull View view){
            super(view);
        }
    }
}
