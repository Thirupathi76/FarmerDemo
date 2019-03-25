package com.demo.farmerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.R;


public class FarmerItemAdapter extends BaseAdapter {

    String[] grid_name;
    Context context;
    String type;
    int[] grid_images;


    public FarmerItemAdapter(Context productActivity, String[] grid_name, int[] grid_images) {
        this.grid_name = grid_name;
        this.grid_images = grid_images;
        context = productActivity;
        this.type = type;

    }

    @Override
    public int getCount() {
        return  grid_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.farmer_items_list, null);
        TextView textView = view.findViewById(R.id.bike_image);
        textView.setText(grid_name[position]);
        ImageView image = view.findViewById(R.id.image);
        image.setImageResource(grid_images[position]);

        return view;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bike_name;
        int sum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bike_name = itemView.findViewById(R.id.bike_image);

        }
    }
}
   /*@NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.farmer_items_list, viewGroup, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.grid_name.setText(grid_name[i]);

        myViewHolder.grid_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*Intent in = new Intent(context, BikeBookListActivity.class);
               context.startActivity(in);*//*
            }
        });

    }

    @Override
    public int getItemCount() {
        return grid_name.length;
    }*/