package com.demo.farmerdemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.farmerdemo.R;

import static android.Manifest.permission.CALL_PHONE;

public class CustomTab2Adapter extends BaseAdapter {
    Context context;
    int[] images1;
    String[] names1;
    int[] images2;
    String[] numbers={"9999999999","9999999999","9999999999","9999999999","9999999999","9999999999","9999999999","9999999999"};
    public CustomTab2Adapter(Context context, int[] images1, String[] names1) {
        this.context=context;
        this.names1=names1;
        this.images1=images1;
        //this.images2=images2;

    }

    @Override
    public int getCount() {
        return images1.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.list_view1,viewGroup,false);
        TextView textView;
        ImageView imageView,imageView1;
        textView=view.findViewById(R.id.textview2);
        imageView=view.findViewById(R.id.circleimage2);
        //imageView1=view.findViewById(R.id.image1);
        textView.setText(names1[i]);
        imageView.setImageResource(images1[i]);
       // imageView1.setImageResource(images2[i]);
       /* imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*for(int i=0;i<numbers.length;i++) {*//*
                    if (checkPermission()) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+numbers[i]));
                        context.startActivity(intent);
                    } else {
                        requestPermissions();
                        Toast.makeText(context, "not given", Toast.LENGTH_SHORT).show();
                    }
//                }
            }
        });*/
        return view;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions((Activity) context,new String[]
                {android.Manifest.permission.CALL_PHONE},100);
    }

    private boolean checkPermission() {
        int call= ContextCompat.checkSelfPermission(context,CALL_PHONE);
        if (call== PackageManager.PERMISSION_GRANTED) {
            return true;
        }else {
            return false;

        }
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case 100:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED

                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {



                    Log.e("value", "Permission Granted, Now you can use local drive .");

                } else {

                    Log.e("value", "Permission Denied, You cannot use local drive .");

                }

                break;

        }
    }


}
