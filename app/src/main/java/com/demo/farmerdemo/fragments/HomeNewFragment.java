package com.demo.farmerdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.farmerdemo.R;
import com.demo.farmerdemo.adapter.HomeItemAdapter;
import com.demo.farmerdemo.adapter.ViewBottomPagerAdapter;
import com.demo.farmerdemo.adapter.ViewPagerAdapter;
import com.demo.farmerdemo.interfaces.ClickListener;

import java.util.Timer;
import java.util.TimerTask;

public class HomeNewFragment extends Fragment  {

    /*ExpandableHeightGridView grid_categories;
    FarmerItemAdapter adapter;*/
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    private ViewPager introPager, introPager2;
    private LinearLayout sliderDotspanel, sliderDotspanel2;

    private int dotscount;
    private ImageView[] dots;

    HomeItemAdapter adapter;
    int[] images_row_1 = { R.drawable.icon_farmer,   R.drawable.virtual_farmer, R.drawable.icon_advisory,R.drawable.icon_farmer_at_work};
    int[] images_row_2 = {R.drawable.icon_logistics, R.drawable.suppliers, R.drawable.merchant_icon, R.drawable.icon_shop_interior};
    String[] names_row_1 = { "Farmer", "Virtual Farmer","Advisory board","Farm workers"};
    String[] names_row_2 = {"Logistic operator","Supplier", "Merchant", "Market Federation"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout_new, null);
        recyclerView = view.findViewById(R.id.recyclerViewBody);
        recyclerView2 = view.findViewById(R.id.recyclerBody2);
        /*gridviewFarmerItems = (ExpandableHeightGridView) findViewById(R.id.gridview_farmer_items);
        homeBannerFrameLayout = (RelativeLayout) view.findViewById(R.id.home_banner_frame_layout);
        homeBannerPager = (ViewPager) view.findViewById(R.id.home_banner_pager);
        homeBannerPagerIndicator = (LinearLayout) view.findViewById(R.id.home_banner_pager_indicator);*/
        String[] grid_names = getResources().getStringArray(R.array.main_grid);
        int[] grid_images = {R.drawable.screenshot_1, R.drawable.screenshot_2,  R.drawable.screenshot_3,  R.drawable.screenshot_4,
                R.drawable.screenshot_5, R.drawable.screenshot_6,  R.drawable.screenshot_7,  R.drawable.screenshot_8,
                R.drawable.screenshot_9, R.drawable.screenshot_1,  R.drawable.screenshot_2};

//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new HomeItemAdapter(getActivity(),images_row_1, names_row_1 ,"Row1", new ClickListener() {
            @Override
            public void itemClick(View view, int pos) {

            }
        });
        recyclerView.setAdapter(adapter);

        adapter = new HomeItemAdapter(getActivity(),images_row_2, names_row_2 ,"Row2", new ClickListener() {
            @Override
            public void itemClick(View view, int pos) {

            }
        });

        recyclerView2.setAdapter(adapter);

       /* grid_categories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
//                    startActivity(new Intent(getActivity(), VFProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new AdvisoryPanelFragment()).commit();
                }
                if (position == 0) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new VirtualFarmerFragment()).commit();

                }if (position == 2) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                }if (position == 4) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new PortfolioManagerFragment()).commit();

                }if (position == 5) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                } *//*if (position == 4) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                }*//*
            }
        });*/
        adapter.notifyDataSetChanged();
        //Slider
        introPager = view.findViewById(R.id.home_banner_pager);
        introPager2 = view.findViewById(R.id.home_banner_bottom_pager);
        sliderDotspanel = view.findViewById(R.id.home_banner_pager_bottom_indicator);
        sliderDotspanel2 = view.findViewById(R.id.home_banner_pager_indicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        ViewBottomPagerAdapter pagerAdapter = new ViewBottomPagerAdapter(getActivity());

        introPager.setAdapter(viewPagerAdapter);
        introPager2.setAdapter(pagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        setUpSlider();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);

       /* setUpSlider2();
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new MyTimerTask2(), 3000, 4000);*/

        getActivity().setTitle("Farmer");
        return view;


    }

    private void setUpSlider() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
//            sliderDotspanel2.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));

        introPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void setUpSlider2() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel2.addView(dots[i], params);
//            sliderDotspanel2.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));

        introPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nonactive_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if (getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
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

    public class MyTimerTask2 extends TimerTask {

        @Override
        public void run() {

            if (getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (introPager2.getCurrentItem() == 0) {
                        introPager2.setCurrentItem(1);
                    } else if (introPager2.getCurrentItem() == 1) {
                        introPager2.setCurrentItem(2);
                    } else if (introPager2.getCurrentItem() == 2) {
                        introPager2.setCurrentItem(3);
                    } else {
                        introPager2.setCurrentItem(0);
                    }

                }
            });
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
