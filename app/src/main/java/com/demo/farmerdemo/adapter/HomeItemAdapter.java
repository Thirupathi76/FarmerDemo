package com.demo.farmerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.AdvisoryTabActivity;
import com.demo.farmerdemo.FarmerListActivity;
import com.demo.farmerdemo.LogisticTabActivity;
import com.demo.farmerdemo.R;
import com.demo.farmerdemo.interfaces.ClickListener;
import com.demo.farmerdemo.product.ProductNavActivity;


public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.MyViewHolder> {

    String[] bike_name;// = {"Farmer", "Virtual Farmer", "Suppliers", "Workers", "e-Logistics", "Operators", "Warehouses"};
    Context context;
    String type;
    int[] images = {R.drawable.icon_advisory, R.drawable.icon_farmer,  R.drawable.icon_farmer_at_work,  R.drawable.virtual_farmer,
            R.drawable.suppliers, R.drawable.icon_shop_interior, R.drawable.merchant_icon};
    String[] names = {"Advisory board", "Farmer","Farm workers", "Virtual Farmer",
            "Supplier", "Merchant", "Market Federation"};
    private ClickListener clickListener;

    public HomeItemAdapter(Context productActivity, String type, ClickListener clickListener) {
        context = productActivity;
        this.type = type;
        this.clickListener = clickListener;
        bike_name = productActivity.getResources().getStringArray(R.array.main_grid);
    }

    public HomeItemAdapter(Context activity, int[] images_row_1, String[] names_row_1, String row1, ClickListener clickListener) {
        context = activity;
        images = images_row_1;
        names = names_row_1;
        this.type = row1;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.home_new_items, viewGroup, false);


        return new MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.bike_name.setText(names[i]);

        myViewHolder.image.setImageResource(images[i]);
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    Intent in = new Intent(context, FarmerListActivity.class);
                    context.startActivity(in);
                } else if (i == 1){
                    context.startActivity(new Intent(context, ProductNavActivity.class));
                } else if (i==2){
                    context.startActivity(new Intent(context, AdvisoryTabActivity.class));
                } else if (i==3){
                    context.startActivity(new Intent(context, LogisticTabActivity.class));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bike_name;
        ImageView image;
        int sum;

        public MyViewHolder(@NonNull final View itemView, final ClickListener clickListener) {
            super(itemView);

            bike_name = itemView.findViewById(R.id.bike_image);
            image = itemView.findViewById(R.id.image);

           /* image.setOnClickListener(new View.OnClickListener() {
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
            });*/
        }
    }
}
