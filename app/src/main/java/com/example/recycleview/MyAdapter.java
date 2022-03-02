package com.example.recycleview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    String[] items;
    String[] desc;
    int[] img;

    public MyAdapter (Context context, String[] items, String[] desc, int[] img){
        this.context = context;
        this.items = items;
        this.desc = desc;
        this.img = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.items.setText(this.items[position]);
        holder.desc.setText(this.desc[position]);
        holder.img.setImageResource(this.img[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView items, desc;
        ImageView img;
        public MyViewHolder (@NonNull View view){
            super(view);
            items = itemView.findViewById(R.id.items);
            desc = itemView.findViewById(R.id.desc);
            img = itemView.findViewById(R.id.img);
        }
    }
}
