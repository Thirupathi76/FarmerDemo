package com.demo.farmerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.demo.farmerdemo.fragments.ColdChainTab;
import com.demo.farmerdemo.fragments.TransportTab;

import java.util.ArrayList;
import java.util.List;

public class AdvisoryTabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistic_tab);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new ColdChainTab(), "Agri");
        adapter.AddFragment(new TransportTab(), "Harti");
        adapter.AddFragment(new ColdChainTab(), "Dairy");
        adapter.AddFragment(new TransportTab(), "Poultry");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentListTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentListTitle.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return fragmentListTitle.get(position);
        }

        public void AddFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentListTitle.add(title);

        }
    }
}

