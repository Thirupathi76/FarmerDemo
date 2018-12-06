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


public class MenuListAdapter extends BaseAdapter {

    String[] list_menus = {"Home", "Share app","My Farmers","Select Language","Profile setting","Edit Profile","Update","My favourites/Cart"};
    Context context;
    int[] images = {R.drawable.screenshot_2,R.drawable.screenshot_3,R.drawable.screenshot_5,R.drawable.screenshot_6,
            R.drawable.screenshot_7,R.drawable.screenshot_8,R.drawable.screenshot_2,R.drawable.screenshot_3};

    public MenuListAdapter(Context productActivity) {
        context = productActivity;
    }

    @Override
    public int getCount() {
        return list_menus.length;
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

        View view = LayoutInflater.from(context).inflate(R.layout.menu_item_list, null);
        TextView menu_name = view.findViewById(R.id.menu_name);
        menu_name.setText(list_menus[position]);
        ImageView menu_image = view.findViewById(R.id.menu_image);
        menu_image.setImageResource(images[position]);
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
