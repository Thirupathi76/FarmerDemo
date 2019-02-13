package com.demo.farmerdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.demo.farmerdemo.adapter.LanguageSelectAdapter;
import com.demo.farmerdemo.bean.PersonItem;

import java.util.ArrayList;
import java.util.List;

public class LanguageSelectionActivity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {


    RecyclerView mRecyclerView;

    private List<PersonItem> mSingleCheckList = new ArrayList<>();
    private LanguageSelectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);

        mRecyclerView = findViewById(R.id.recylcerview);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Select Language");
        mSingleCheckList.clear();
        /*for (int i = 0; i < 20; i++) {
            mSingleCheckList.add(new PersonItem("This is a sample for single check Recycelrview"));
        }*/
        mSingleCheckList.add(new PersonItem("Telugu"));
        mSingleCheckList.add(new PersonItem("English"));
        mSingleCheckList.add(new PersonItem("Urdu"));
        mSingleCheckList.add(new PersonItem("Hindi"));
        mSingleCheckList.add(new PersonItem("Kannada"));
        mSingleCheckList.add(new PersonItem("Malayalam"));
        mSingleCheckList.add(new PersonItem("Tamil"));
        mSingleCheckList.add(new PersonItem("Marati"));
        mSingleCheckList.add(new PersonItem("Gujarathi"));
        mSingleCheckList.add(new PersonItem("Bengali"));

        mAdapter = new LanguageSelectAdapter(LanguageSelectionActivity.this, mSingleCheckList);
        mRecyclerView = findViewById(R.id.recylcerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(this);
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(LanguageSelectionActivity.this, position + " - " + mSingleCheckList.get(position).getPersonName(), Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.done:
                startActivity(new Intent(LanguageSelectionActivity.this, PlayIntroVideo.class));
                return true;

        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
