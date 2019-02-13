package com.demo.farmerdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.demo.farmerdemo.R;
import com.demo.farmerdemo.adapter.FarmerItemAdapter;
import com.demo.farmerdemo.adapter.ViewPagerAdapter;
import com.demo.farmerdemo.views.ExpandableHeightGridView;

import java.util.Timer;
import java.util.TimerTask;

public class PortfolioManagerFragment extends Fragment  {

    ExpandableHeightGridView grid_categories;
    FarmerItemAdapter adapter;

    private ViewPager introPager;
    private LinearLayout sliderDotspanel;

    private int dotscount;
    private ImageView[] dots;

    private ExpandableHeightGridView gridviewFarmerItems;
    private RelativeLayout homeBannerFrameLayout;
    private ViewPager homeBannerPager;
    private LinearLayout homeBannerPagerIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        grid_categories = view.findViewById(R.id.gridview_farmer_items);
        /*gridviewFarmerItems = (ExpandableHeightGridView) findViewById(R.id.gridview_farmer_items);
        homeBannerFrameLayout = (RelativeLayout) view.findViewById(R.id.home_banner_frame_layout);
        homeBannerPager = (ViewPager) view.findViewById(R.id.home_banner_pager);
        homeBannerPagerIndicator = (LinearLayout) view.findViewById(R.id.home_banner_pager_indicator);*/
        String[] grid_names = getResources().getStringArray(R.array.vf_grid);
        int[] grid_images = {R.drawable.screenshot_1, R.drawable.screenshot_2,  R.drawable.screenshot_3,  R.drawable.screenshot_4,
                R.drawable.screenshot_5, R.drawable.screenshot_6,  R.drawable.screenshot_7,  R.drawable.screenshot_8,
                R.drawable.screenshot_9, R.drawable.screenshot_1,  R.drawable.screenshot_2};

        adapter = new FarmerItemAdapter(getActivity(), grid_names, grid_images);

        grid_categories.setAdapter(adapter);
        grid_categories.setExpanded(true);

        grid_categories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
//                    startActivity(new Intent(getActivity(), VFProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new VirtualFarmerFragment()).commit();
                }
                if (position == 0) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new FarmerFragment()).commit();

                }if (position == 2) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new AdvisoryPanelFragment()).commit();

                }if (position == 4) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new MerchantFragment()).commit();

                }if (position == 5) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                } /*if (position == 4) {
//                    startActivity(new Intent(getActivity(), NavProfileActivity.class));
                    getFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupplierFragment()).commit();

                }*/
            }
        });
        adapter.notifyDataSetChanged();
        //Slider
        introPager = view.findViewById(R.id.home_banner_pager);
        sliderDotspanel = view.findViewById(R.id.home_banner_pager_indicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());

        introPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        setUpSlider();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);

        getActivity().setTitle("Portfolio Manager");
        return view;


    }

    private void setUpSlider() {


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

}
