package com.example.recycleview;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    String[] items, desc;
    int[] img;
    private ItemClickListener clickListener;

    public MyAdapter (String[] items, String[] desc, int[] img, ItemClickListener clickListener){
        this.items = items;
        this.desc = desc;
        this.img = img;
        this.clickListener  = clickListener;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        int position = pos;
        holder.items.setText(items[position]);
        holder.img.setImageResource(img[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(items[position], desc[position], img[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView items, desc;
        ImageView img;
        ConstraintLayout mainLayout;
        public MyViewHolder (@NonNull View view){
            super(view);
            items = view.findViewById(R.id.items);
            img = view.findViewById(R.id.img);
            mainLayout = view.findViewById(R.id.mainLayout);
        }
    }
    public interface ItemClickListener {

        public void onItemClick(String name, String desc, int img);
    }
}
