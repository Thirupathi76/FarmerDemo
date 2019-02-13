package com.demo.farmerdemo.appapi;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppApi {

    public static final String BASE_URL = "http://tsmepma.in/smarttrack/API/";

    public static AppService createAppService(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//gson
                .client(client)
                .build();

        return retrofit.create(AppService.class);
    }


}
