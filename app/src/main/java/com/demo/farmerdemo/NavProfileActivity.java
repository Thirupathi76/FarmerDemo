package com.demo.farmerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.demo.farmerdemo.adapter.FarmerHeaderAdapter;
import com.demo.farmerdemo.adapter.FarmerItemAdapter;
import com.demo.farmerdemo.adapter.MenuListAdapter;
import com.demo.farmerdemo.utils.ItemOffsetDecoration;
import com.demo.farmerdemo.utils.SimpleDividerItemDecoration;

public class NavProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView recyclerView_cars;
    FarmerItemAdapter adapter;
    MenuListAdapter menuAdapter;
    ListView list_menus;
    RecyclerView recycler_header;
    FarmerHeaderAdapter headerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recycler_header = findViewById(R.id.recycler_header);
        recycler_header.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView_cars = findViewById(R.id.recyclerViewId);
        headerAdapter = new FarmerHeaderAdapter(this, "");

        recycler_header.setAdapter(headerAdapter);

        list_menus = findViewById(R.id.list_menus);
        menuAdapter = new MenuListAdapter(this);
        list_menus.setAdapter(menuAdapter);
        /*recyclerView_cars.setLayoutManager(new GridLayoutManager(this,4));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView_cars.addItemDecoration(itemDecoration);*/
//        recyclerView_cars.addItemDecoration(new SimpleDividerItemDecoration(this));
        adapter = new FarmerItemAdapter(this, "Cars");
        recyclerView_cars.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_easy_farmer) {

        } else if (id == R.id.nav_my_farmer) {

        } else if (id == R.id.nav_my_orders) {

        } else if (id == R.id.nav_language) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
