package com.demo.farmerdemo.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.R;

class CategoriesAdapter extends BaseAdapter {
    Context context;
    String[] fruits;
    int[] images;

    public CategoriesAdapter(Context context, String[] fruitsArray, int[] images) {

        this.context = context;
        this.fruits = fruitsArray;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
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


        View view = LayoutInflater.from(context).inflate(R.layout.activity_homegrid,null);

        TextView textView = (TextView)view.findViewById(R.id.text);
        textView.setText(fruits[position]);

        ImageView image = view.findViewById(R.id.image);
        image.setImageResource(images[position]);

        return view;


    }
}
