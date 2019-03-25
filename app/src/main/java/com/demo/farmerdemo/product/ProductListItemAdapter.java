package com.demo.farmerdemo.product;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.R;

public class ProductListItemAdapter extends RecyclerView.Adapter {

    Context context;
    int[] images;
    String[] name;
    String[] price;
    ViewHolderClass viewHolderClass;
    private ProductClickListener productClickListener;

    ImageView image;


    public ProductListItemAdapter(ProductItemListActivity productItemListActivity, String[] name, String[] price, int[] images, ProductClickListener productClickListener) {

        this.context = productItemListActivity;
        this.images = images;
        this.name = name;
        this.price = price;
        this.productClickListener = productClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.prod_list_item_layout, viewGroup, false );
        viewHolderClass = new ViewHolderClass( view, productClickListener);
        return viewHolderClass;

        /*return new ViewHolderClass( view, productClickListener );*/

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        viewHolderClass.textView1.setText( name[i] );
        viewHolderClass.textView2.setText( "\u20B9" + price[i] );
        viewHolderClass.image.setImageResource( images[i] );


        viewHolderClass.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, ProductItemDetailActivity.class );
                context.startActivity( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    private class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        ImageView image;
        TextView plus, minus;
        TextView quantity;

        int sum;

        public ViewHolderClass(View view, final ProductClickListener productClickListener) {
            super( view );

            textView1 = view.findViewById( R.id.name );
            textView2 = view.findViewById( R.id.price );
            image = view.findViewById( R.id.imageveg );
            plus = view.findViewById( R.id.plus );
            minus = view.findViewById( R.id.minus );
            quantity = view.findViewById( R.id.tv_quantity );

            plus.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sum = sum + 1;
                    if (sum > 0) {
                        quantity.setVisibility( View.VISIBLE );
                        minus.setVisibility( View.VISIBLE );
                    }
                    quantity.setText( String.valueOf( sum ) );
                    productClickListener.itemClick( view, getAdapterPosition(), sum );
                }
            } );

            minus.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sum > 0) {
                        sum = sum - 1;
                        if (sum == 0) {
                            quantity.setVisibility( View.INVISIBLE );
                            minus.setVisibility( View.INVISIBLE );
                        }
                        quantity.setText( String.valueOf( sum ) );
                        productClickListener.itemClick( view, getAdapterPosition(), sum );
                    }
                }
            } );
        }
    }
}

