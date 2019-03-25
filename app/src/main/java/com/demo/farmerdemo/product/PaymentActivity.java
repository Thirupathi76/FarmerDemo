package com.demo.farmerdemo.product;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.demo.farmerdemo.R;

import java.util.ArrayList;
import java.util.Set;

//import com.marolix.doctorapp.utils.Utilities;

public class PaymentActivity extends AppCompatActivity {

    private static final String MY_PREFERENCES = "MY_PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ((TextView)findViewById(R.id.text_payment)).setText(getIntent().getStringExtra("CART"));
        ArrayList<String> prod_list = new ArrayList<>();
        prod_list = getArrayPreference(this, "ORDER_DETAILS");
        Log.e("Prod_details", prod_list.toString());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Payment");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public static ArrayList<String> getArrayPreference(Context context, String TAG) {
        System.out.println("Contextget=" + context);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        Set<String> value = preferences.getStringSet(TAG, null);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(arrayList);
        return arrayList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
