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

public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ViewHolderClass> {
    Context context;
    Integer[] images;
    String[] arr;

    public ToolsAdapter(Context mainActivity, Integer[] images, String[] arr, String[] arr1) {
        context = mainActivity;
        this.images = images;
        this.arr = arr;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.tools_list_item, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        /*viewHolderClass.images.setImageResource(images[i]);
        viewHolderClass.products.setText(arr[i]);*/
//        viewHolderClass.txt_address.setText(arr[i]);
//        viewHolderClass.images1.setImageResource(images1[i;
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView images;
        TextView products, txt_address;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.tool_image);
            products = itemView.findViewById(R.id.txt_name);
            txt_address = itemView.findViewById(R.id.txt_address);

        }
    }
}

