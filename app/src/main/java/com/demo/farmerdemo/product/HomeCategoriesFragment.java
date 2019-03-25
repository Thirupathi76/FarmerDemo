package com.demo.farmerdemo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.demo.farmerdemo.R;

public class HomeCategoriesFragment extends Fragment {

    String[] fruitsArray = {"Fruits & Vegetables", "Bread , Dairy & Eggs", "Beverages", "PersonalCare", "Fruits & Vegetables", "Bread , Dairy & Eggs", "Beverages", "PersonalCare"};
    int[] images = {R.drawable.fruitsandvegetables,
            R.drawable.breadeggs,
            R.drawable.beverages,
            R.drawable.personalcare,
            R.drawable.fruitsandvegetables,
            R.drawable.breadeggs,
            R.drawable.beverages,
            R.drawable.personalcare};

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.categories_frag, container, false);

        GridView gridView = view.findViewById(R.id.fruits_list);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getContext(), fruitsArray, images);
        gridView.setAdapter(categoriesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ProductItemListActivity.class));
            }
        });

        return view;
    }
}
