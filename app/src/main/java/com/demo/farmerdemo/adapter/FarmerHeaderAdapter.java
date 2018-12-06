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


public class FarmerHeaderAdapter extends RecyclerView.Adapter<FarmerHeaderAdapter.MyViewHolder> {

    String[] bike_name = {"Logistics", "info","Market","Supplier","Govt","Authority","Advisory","Orders"};
    Context context;
    String type;
    int[] images = {R.drawable.screenshot_2,R.drawable.screenshot_3,R.drawable.screenshot_5,R.drawable.screenshot_6,
            R.drawable.screenshot_7,R.drawable.screenshot_8,R.drawable.screenshot_2,R.drawable.screenshot_3};

    public FarmerHeaderAdapter(Context productActivity, String type) {
        context = productActivity;
        this.type = type;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.farmer_header_list, viewGroup, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.bike_name.setText(bike_name[i]);

        myViewHolder.image.setImageResource(images[i]);
        myViewHolder.bike_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent in = new Intent(context, BikeBookListActivity.class);
               context.startActivity(in);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return bike_name.length;
    }

    /*@Override
    public int getCount() {
        return  bike_name.length;
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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bike_name = itemView.findViewById(R.id.bike_image);
            image = itemView.findViewById(R.id.image);

        }
    }
}
