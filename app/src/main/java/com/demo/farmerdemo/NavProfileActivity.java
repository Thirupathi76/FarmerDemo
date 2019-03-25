package com.demo.farmerdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.demo.farmerdemo.adapter.FarmerHeaderAdapter;
import com.demo.farmerdemo.adapter.MenuListAdapter;
import com.demo.farmerdemo.adapter.OverlayItemAdapter;
import com.demo.farmerdemo.adapter.ViewPagerAdapter;
import com.demo.farmerdemo.fragments.HomeNewFragment;
import com.demo.farmerdemo.interfaces.ClickListener;

import java.util.Timer;
import java.util.TimerTask;

public class NavProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    MenuListAdapter menuAdapter;
    ListView list_menus;
    RecyclerView recycler_header;
    FarmerHeaderAdapter headerAdapter;
    BottomNavigationView bottomNavigationView;

    private ViewPager introPager;
    private LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    LinearLayout layout_list;
    RecyclerView rv_list_overlay_items;

    FloatingActionButton fab;
    RelativeLayout overlay_layout;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Farmer");
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_green_whatsapp));
        /*if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Farmer");
        }*/
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_account) {
                    // on favorites clicked
                    startActivity(new Intent(NavProfileActivity.this, ProfileActivity.class));
                    return true;
                }
                return false;
            }
        });

        overlay_layout = findViewById(R.id.overlay_layout);
        overlay_layout.setVisibility(View.GONE);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_menu_close_clear_cancel));
                    flag = false;

                    overlay_layout.setVisibility(View.VISIBLE);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(rv_list_overlay_items, "x", 0f, 1f);
                    anim.setDuration(1000);
                    anim.start();


                } else {

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_menu_help));
                    flag = true;
                    overlay_layout.setVisibility(View.GONE);
                }

            }
        });

        // slider

        sliderDotspanel = findViewById(R.id.home_banner_pager_indicator);
        introPager = findViewById(R.id.home_banner_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        // overlay screens
        rv_list_overlay_items = findViewById(R.id.rv_list_overlay_items);
        rv_list_overlay_items.setLayoutManager(new GridLayoutManager(this, 2));
        OverlayItemAdapter overlayItemAdapter = new OverlayItemAdapter(this);
        rv_list_overlay_items.setAdapter(overlayItemAdapter);

        layout_list = findViewById(R.id.layout_list);
        layout_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavProfileActivity.this, "Clicked layout", Toast.LENGTH_SHORT).show();
            }
        });
        introPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        setUpSlider();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);

        recycler_header = findViewById(R.id.recycler_header);
        recycler_header.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        headerAdapter = new FarmerHeaderAdapter(this, "", new ClickListener(){
            @Override
            public void itemClick(View view, int pos) {
                if (pos == 1) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new VirtualFarmerFragment()).commit();
                }
                if (pos == 0) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FarmerFragment()).commit();

                }if (pos == 2) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                }if (pos == 3) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AdvisoryPanelFragment()).commit();

                } if (pos == 4) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LogisticFragment()).commit();

                } if (pos == 5) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MerchantFragment()).commit();

                } if (pos == 6) {
                    startActivity(new Intent(NavProfileActivity.this, FarmerListActivity.class));
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new WarehouseFragment()).commit();
                }
               
            }
        });

        recycler_header.setAdapter(headerAdapter);
        list_menus = findViewById(R.id.list_menus);
        menuAdapter = new MenuListAdapter(this);
        list_menus.setAdapter(menuAdapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.text_green_whatsapp));*/


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ImageView image=(ImageView) findViewById(R.id.menu);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeNewFragment()).commit();
    }


    private void setUpSlider() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(NavProfileActivity.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(NavProfileActivity.this, R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(NavProfileActivity.this, R.drawable.nonactive_dot));

        introPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(NavProfileActivity.this, R.drawable.active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(NavProfileActivity.this, R.drawable.nonactive_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

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

    /*@Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeNewFragment()).commit();

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
