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

public class AdapterNewFarmerList extends RecyclerView.Adapter<AdapterNewFarmerList.ViewHolderClass> {
    Context context;
    Integer[] images;
    String[] arr;
    String[] arr1;
    String[] arr2;
    String[] arr3;
    Integer[] images1;

    public AdapterNewFarmerList(Context mainActivity, Integer[] images, String[] arr, String[] arr1, String[] arr2, String[] arr3, Integer[] images1) {
        this.context = mainActivity;
        this.images = images;
        this.arr = arr;
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.arr3 = arr3;
        this.images1 = images1;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_list_farmer, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.images.setImageResource(images[i]);
        viewHolderClass.products.setText(arr[i]);
        viewHolderClass.address.setText(arr1[i]);
        viewHolderClass.managername.setText(arr2[i]);
        viewHolderClass.mobile.setText(arr3[i]);
//        viewHolderClass.images1.setImageResource(images1[i;
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView images;
        TextView products;
        TextView address;
        TextView managername;
        TextView mobile;
        TextView images1;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.img);
            products = itemView.findViewById(R.id.jute);
            address = itemView.findViewById(R.id.qunitals);
            managername = itemView.findViewById(R.id.min);
            mobile = itemView.findViewById(R.id.max);
            images1 = itemView.findViewById(R.id.view);
        }
    }
}

