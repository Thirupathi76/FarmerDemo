package com.demo.farmerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.farmerdemo.R;

public class PesticidesAdapter extends RecyclerView.Adapter<PesticidesAdapter.ViewHolderClass> {
    Context context;
    String[] arr;
    String[] arr1;
    String[] arr2;
    String[] arr3;
    String[] arr4;

    public PesticidesAdapter(Context mainActivity, String[] arr, String[] arr1, String[] arr2, String[] arr3, String[] arr4) {
        context = mainActivity;
        this.arr = arr;
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.arr3 = arr3;
        this.arr4 = arr4;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {

        viewHolderClass.products.setText(arr[i]);
        viewHolderClass.address.setText("Address : " + arr1[i]);
        viewHolderClass.managername.setText("Manager name : " + arr2[i]);
        viewHolderClass.mobile.setText("mobile : " + arr3[i]);
        viewHolderClass.capacity.setText("Capacity In MT : " + arr4[i]);

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView products;
        TextView address;
        TextView managername;
        TextView mobile;
        TextView capacity;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            products = itemView.findViewById(R.id.txt);
            address = itemView.findViewById(R.id.adress);
            managername = itemView.findViewById(R.id.mgrname);
            mobile = itemView.findViewById(R.id.mobile);
            capacity = itemView.findViewById(R.id.capacity);

        }
    }
}






