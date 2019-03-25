package com.demo.farmerdemo.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.farmerdemo.R;

public class ProductItemListActivity extends AppCompatActivity {

    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;
    DatabaseProducts databaseProducts;


    private RecyclerView recyclerView;
    int[] images = {R.drawable.fru1,
            R.drawable.fruit2,
            R.drawable.fru3,
            R.drawable.fru4,
            R.drawable.fruitsandvegetables};
    String[] name = {"apple", "Tomato", "kiwi", "strawberry", "broccoli"};
    String[] price = {"30", "40", "150", "130", "50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_list);
        databaseProducts = new DatabaseProducts(ProductItemListActivity.this);
        bottom_cart_layout = findViewById(R.id.bottom_cart_layout);
        text_cart = findViewById(R.id.cart_text);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductListItemAdapter productListItemAdapter = new ProductListItemAdapter(this, name, price, images, new ProductClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {

                if (view.getId() == R.id.plus) {
                    Log.e("Click ", "databaseProducts " + pos);
                    total = total + Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9" + total);


                    if (!databaseProducts.checkIfExists(name[pos])) {

                        databaseProducts.addItemsToCart(name[pos], price[pos], String.valueOf(quantity));
                    } else if (quantity == 0) {
                        databaseProducts.removeItemsFromCart(name[pos]);
                    } else
                        databaseProducts.updateCartItems(name[pos], price[pos], String.valueOf(quantity));
                   /* total = total + Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to CartModel items \u20B9 " + total);*/

                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                } else if (view.getId() == R.id.minus) {

                    total = total - Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9" + total);

                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }

                }

            }
        });
        recyclerView.setAdapter(productListItemAdapter);
        bottom_cart_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductItemListActivity.this, CartActivity.class);
                i.putExtra("CART", String.valueOf(total));
                startActivity(i);
            }
        });

    }
}
