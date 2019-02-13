package com.demo.farmerdemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.demo.farmerdemo.R;
import com.demo.farmerdemo.adapter.CustomTabAdapter;

public class ColdChainTab extends Fragment {
    ListView listview;
    int[] images1={R.drawable.boys,
            R.drawable.boyt,
            R.drawable.girls,
            R.drawable.boyp,
            R.drawable.boyj,
            R.drawable.boyv,
            R.drawable.boyn,
            R.drawable.girlv};
    String[] names1={"Surya","Tirupathi","Swetha","Pavan","JayaKrishna","Varun","Nithin","Vinitha"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_1,container,false);
        listview=view.findViewById(R.id.listview);
        CustomTabAdapter adapter1=new CustomTabAdapter(getActivity(),images1,names1);
        listview.setAdapter(adapter1);
        return view;
    }
}
