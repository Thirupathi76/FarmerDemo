package com.demo.farmerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.demo.farmerdemo.adapter.AdapterNewFarmerList;


public class FarmerListNewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Integer[] images1 = {R.drawable.pp, R.drawable.maize, R.drawable.paddy, R.drawable.turmeric};
    String[] arr = {"Jute", "Maize", "Paddy(Dhan)", "Turmeric(raw)"};
    String[] arr1 = {"60 quintals", "70 quintals", "70 quintals", "60 quintals"};
    String[] arr2 = {"Min price:Rs.7,000 quintals", "Min price:Rs.1,000 quintals", "Min price:Rs.2,000 quintals", "Min price:Rs.4,000 quintals"};
    String[] arr3 = {"Max price:Rs.7,000 quintals", "Max price:Rs.1,800 quintals", "Max price:Rs.2,000 quintals", "Max price:Rs.4,000 quintals"};
    String[] arr4 = {"view details", "view details", "view details", "view details"};
    private Integer[] images = {R.drawable.ic_share_black_24dp,
            R.drawable.ic_share_black_24dp,
            R.drawable.ic_share_black_24dp,
            R.drawable.ic_share_black_24dp};
    private ArrayAdapter<String> adapter;
    private AdapterNewFarmerList recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_new_list_activity);
        recyclerView = findViewById(R.id.recycle1);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager staggeredGridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recycler = new AdapterNewFarmerList(this, images1, arr, arr1, arr2, arr3, images);
        recyclerView.setAdapter(recycler);
        recycler.notifyDataSetChanged();
    }
}