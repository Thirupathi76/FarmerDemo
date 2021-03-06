package com.demo.farmerdemo.product;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.farmerdemo.R;

import java.util.ArrayList;

//import com.marolix.doctorapp.adapter.CartListAdapter;
//import com.marolix.doctorapp.database.DatabaseProducts;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    DatabaseProducts databaseProducts;
    TextView amount_total, apply_promocode;

    LinearLayout proceed_layout;
    private ArrayList<CartModel> data;
    private CartListAdapter adapter;

    EditText et_promo_code;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;
    private TextInputLayout inputLayoutPromocode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        String cart_amount = getIntent().getStringExtra("CART");

        et_promo_code = findViewById(R.id.et_promo_code);

        amount_total = findViewById(R.id.amount_total);
        apply_promocode = findViewById(R.id.apply_promocode);
        proceed_layout = findViewById(R.id.proceed_layout);
        inputLayoutPromocode = findViewById(R.id.inputLayoutPromocode);

        preferences = getSharedPreferences("FIRST_RUN", Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        if (isFirstRun("FIRST_PROMO_CODE")) {
            inputLayoutPromocode.setHelperText("Use FOOD50 promocode to avail 50% off");
        }
        proceed_layout.setOnClickListener(this);
        apply_promocode.setOnClickListener(this);

        findViewById(R.id.proceed_btn).setOnClickListener(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("CartModel");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        databaseProducts = new DatabaseProducts(this);
//        cart_amount = String.valueOf(databaseProducts.getAllCartAmount());
        recyclerView = findViewById(R.id.cart_recycler_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        data = databaseProducts.getAllCartData();
        updateCartAmount();
//        Log.e("data databaseProducts", data.toString());
        adapter = new CartListAdapter(this, data, new ProductClickListener() {

            @Override
            public void itemClick(View view, int pos, int quantity) {
                if (view.getId() == R.id.item_add) {


                    if (!databaseProducts.checkIfExists(data.get(pos).getItemName())) {

                        databaseProducts.addItemsToCart(data.get(pos).getItemName(), data.get(pos).getItemPrice(), String.valueOf(quantity));
                    } else if (quantity == 0) {
                        data.remove(pos);
                        adapter.notifyItemRemoved(pos);
                        databaseProducts.removeItemsFromCart(data.get(pos).getItemName());
                    } else
                        databaseProducts.updateCartItems(data.get(pos).getItemName(), data.get(pos).getItemPrice(), String.valueOf(quantity));


                    updateCartAmount();

                } else if (view.getId() == R.id.item_sub) {


                    if (!databaseProducts.checkIfExists(data.get(pos).getItemName())) {
                        databaseProducts.addItemsToCart(data.get(pos).getItemName(), data.get(pos).getItemPrice(), String.valueOf(quantity));
                    } else if (quantity == 0) {
                        databaseProducts.removeItemsFromCart(data.get(pos).getItemName());
                        data.remove(pos);
                        adapter.notifyItemRemoved(pos);
                    } else
                        databaseProducts.updateCartItems(data.get(pos).getItemName(), data.get(pos).getItemPrice(), String.valueOf(quantity));

                    updateCartAmount();
                }
            }
        });


        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private void updateCartAmount() {

        String cart_amount = String.valueOf(databaseProducts.getAllCartAmount());
        amount_total.setText("\u20B9 " + cart_amount);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.proceed_layout:
            case R.id.proceed_btn:
                Intent intent = new Intent(new Intent(CartActivity.this, PaymentActivity.class));
                intent.putExtra("CART", String.valueOf(databaseProducts.getAllCartAmount()));
                startActivity(intent);
                break;
            case R.id.apply_promocode:
                String promo_text = et_promo_code.getText().toString();
                if (promo_text.equals("FOOD50")) {

                    if (isFirstRun("PROMO_CODE")) {

                        int cart_amount = databaseProducts.getAllCartAmount();
                        cart_amount = cart_amount / 2;
                        amount_total.setText("\u20B9 " + cart_amount);
                        et_promo_code.setText("");
                        inputLayoutPromocode.setHelperText("Promo code applied successfully");
                        Toast.makeText(this, "FOOD50 applied successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        inputLayoutPromocode.setError("This promo code applied only once per user");
                        Toast.makeText(this, "This promo code applied only once per user", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CartActivity.this, "Please check the promo code", Toast.LENGTH_SHORT).show();
                    inputLayoutPromocode.setError("Please check the promo code");
                }
                break;
        }
    }

    public boolean isFirstRun(String forWhat) {
        if (preferences.getBoolean(forWhat, true)) {
            preferencesEditor.putBoolean(forWhat, false).commit();
            return true;
        } else {
            return false;
        }
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
