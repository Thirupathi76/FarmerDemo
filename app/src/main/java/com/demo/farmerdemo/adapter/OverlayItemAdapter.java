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

public class OverlayItemAdapter extends RecyclerView.Adapter<OverlayItemAdapter.ViewHolderClass> {
    Context context;
    Integer[] images = {R.drawable.icon_advisory, R.drawable.icon_farmer,  R.drawable.icon_farmer_at_work,  R.drawable.virtual_farmer,
             R.drawable.icon_farmer,  R.drawable.icon_farmer_at_work};
    String[] arr;

    public OverlayItemAdapter(Context mainActivity) {
        context = mainActivity;

    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.overlay_item_list, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.images.setImageResource(images[i]);
//        viewHolderClass.products.setText(arr[i]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView images;
        TextView products;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image_item);
            products = itemView.findViewById(R.id.item_name);

        }
    }
}

