package com.demo.farmerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.demo.farmerdemo.adapter.PesticidesAdapter;

public class PesticidesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    String[] arr = {"MADEENA FOOD AGRO S PRODUCTS", "VENKATESHWARA BANANA MANDI", "MADINA FRUITS", "SAFA COMPANY"};
    String[] arr1 = {"PK STREET,OLD BUS STAND", "17-102,SUNDARAIAH STREET", "PILLERU ROAD,MAIN ROAD,KALLUR", "MAIN ROAD,ROAD BYPASS,KATTUR"};
    String[] arr2 = {"t.munawar ali", "m.munikrishna reddy", "ps.sayed basha", "s.bavaji"};
    String[] arr3 = {"988509932", "9441151622", "9985234768", "9885553863"};
    String[] arr4 = {"N/A", "N/A", "10", "N/A"};
    private ArrayAdapter<String> adapter;
    private PesticidesAdapter recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_pesticides);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager staggeredGridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recycler = new PesticidesAdapter(this, arr, arr1, arr2, arr3, arr4);
        recyclerView.setAdapter(recycler);
        recycler.notifyDataSetChanged();
    }

}

