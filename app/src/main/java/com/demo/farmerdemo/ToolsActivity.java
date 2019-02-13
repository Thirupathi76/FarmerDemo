package com.demo.farmerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.farmerdemo.adapter.ToolsAdapter;

public class ToolsActivity extends AppCompatActivity {

    RecyclerView recyclerViewTools;
    ToolsAdapter adapter;
    private Integer[] images1={R.drawable.transport,R.drawable.transport,R.drawable.transport,R.drawable.transport};
    String[] arr={"Tractor","Van","Auto","JCB"};
    String[] arr1={"60 quintals","70 quintals","70 quintals","60 quintals"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        recyclerViewTools = findViewById(R.id.rv_tools);
        adapter = new ToolsAdapter(this, images1, arr, arr1 );
        recyclerViewTools.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTools.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
