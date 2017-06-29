package com.ukraine.beiandrii.randomusersandroid.service;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by psihey on 28.06.17.
 */

public class RetrofitProvider {
    private static RetrofitQueries sRetrofitQueries;
    private final static String BASE_URL = "https://randomuser.me/";

    private RetrofitProvider() {
    }

    public static RetrofitQueries getRetrofit() {
        if (sRetrofitQueries == null) {
            setUpRetrofit();
        }
        return sRetrofitQueries;

    }

    private static void setUpRetrofit() {

        sRetrofitQueries = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RetrofitQueries.class);
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
