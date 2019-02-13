package com.demo.farmerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.R;
import com.demo.farmerdemo.interfaces.ClickListener;


public class FarmerHeaderAdapter extends RecyclerView.Adapter<FarmerHeaderAdapter.MyViewHolder> {

    String[] bike_name;// = {"Farmer", "Virtual Farmer", "Suppliers", "Workers", "e-Logistics", "Operators", "Warehouses"};
    Context context;
    String type;
    int[] imagess = {R.drawable.screenshot_3, R.drawable.screenshot_5, R.drawable.screenshot_2, R.drawable.screenshot_6,
            R.drawable.screenshot_7, R.drawable.screenshot_8, R.drawable.screenshot_2};

    int[] images = {R.drawable.icon_advisory, R.drawable.icon_farmer,  R.drawable.icon_farmer_at_work,  R.drawable.virtual_farmer,
            R.drawable.suppliers/*, R.drawable.screenshot_6,  R.drawable.screenshot_7,  R.drawable.screenshot_8,
            R.drawable.screenshot_9, R.drawable.screenshot_1,  R.drawable.screenshot_2,  R.drawable.screenshot_3,  R.drawable.screenshot_4,
            R.drawable.screenshot_5, R.drawable.screenshot_6,  R.drawable.screenshot_7*/};
    private ClickListener clickListener;

    public FarmerHeaderAdapter(Context productActivity, String type, ClickListener clickListener) {
        context = productActivity;
        this.type = type;
        this.clickListener = clickListener;
        bike_name = productActivity.getResources().getStringArray(R.array.main_grid);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.farmer_header_list, viewGroup, false);


        return new MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.bike_name.setText(bike_name[i]);

        myViewHolder.image.setImageResource(images[i]);
        /*myViewHolder.bike_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*Intent in = new Intent(context, VFProfileActivity.class);
               context.startActivity(in);*//*

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    /*@Override
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

        return view;
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bike_name;
        ImageView image;
        int sum;

        public MyViewHolder(@NonNull final View itemView, final ClickListener clickListener) {
            super(itemView);

            bike_name = itemView.findViewById(R.id.bike_image);
            image = itemView.findViewById(R.id.image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.itemClick(v, getAdapterPosition());
                }
            });

            bike_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.itemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
