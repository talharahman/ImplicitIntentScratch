package org.pursuit.implicitintentsfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static String BASE_URL = "https://raw.githubusercontent.com/";
    private static Retrofit ourInstance;

    public static Retrofit getInstance() {
        if (ourInstance != null) {
            return ourInstance;
        }
        ourInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return ourInstance;

    }
    private RetrofitSingleton() {
    }
}
