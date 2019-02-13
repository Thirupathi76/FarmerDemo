package com.demo.farmerdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.demo.farmerdemo.adapter.FarmerHeaderAdapter;
import com.demo.farmerdemo.adapter.MenuListAdapter;
import com.demo.farmerdemo.interfaces.ClickListener;

public class VFProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*ExpandableHeightGridView grid_categories;
    FarmerItemAdapter adapter;*/
    MenuListAdapter menuAdapter;
    ListView list_menus;
    RecyclerView recycler_header;
    FarmerHeaderAdapter headerAdapter;

    /*private ViewPager introPager;
    private LinearLayout sliderDotspanel;

    private int dotscount;
    private ImageView[] dots;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Virtual Farmer");

        }
        recycler_header = findViewById(R.id.recycler_header);
        recycler_header.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
//        grid_categories = findViewById(R.id.gridview_farmer_items);
        headerAdapter = new FarmerHeaderAdapter(this, "", new ClickListener() {
            @Override
            public void itemClick(View view, int pos) {

            }
        });

        recycler_header.setAdapter(headerAdapter);
        list_menus = findViewById(R.id.list_menus);
        menuAdapter = new MenuListAdapter(this);
        list_menus.setAdapter(menuAdapter);
        /*grid_categories.setLayoutManager(new GridLayoutManager(this,4));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        grid_categories.addItemDecoration(itemDecoration);*/
//        grid_categories.addItemDecoration(new SimpleDividerItemDecoration(this));
        String[] grid_names = getResources().getStringArray(R.array.vf_grid);
        int[] grid_images = getResources().getIntArray(R.array.vf_grid_image);

       /* adapter = new FarmerItemAdapter(this, grid_names, grid_images);
        grid_categories.setAdapter(adapter);
        grid_categories.setExpanded(true);
        adapter.notifyDataSetChanged();*/

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        //Slider
        /*introPager = findViewById(R.id.home_banner_pager);
        sliderDotspanel = findViewById(R.id.home_banner_pager_indicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        introPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        setUpSlider();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);*/
    }

    /*private void setUpSlider() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nonactive_dot));

        introPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(VFProfileActivity.this, R.drawable.active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(VFProfileActivity.this, R.drawable.nonactive_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            *//*if (HomeActivity.this == null)
                return;*//*
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (introPager.getCurrentItem() == 0) {
                        introPager.setCurrentItem(1);
                    } else if (introPager.getCurrentItem() == 1) {
                        introPager.setCurrentItem(2);
                    } else if (introPager.getCurrentItem() == 2) {
                        introPager.setCurrentItem(3);
                    } else {
                        introPager.setCurrentItem(0);
                    }

                }
            });
        }

    }*/
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
