package com.indeco.trainingandroid.io.remote;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static String URL;

    public static Retrofit getRetrofitInstance(String BASE_URL) throws Exception {
        try {
            URL = BASE_URL;
            if (retrofit == null) {
                createRetrofitInstance(URL);
            }

            return retrofit;

        } catch (Exception e) {
            Log.e("Retrofit Error", Objects.requireNonNull(e.getMessage()));
            throw e;
        }
    }

    private static void createRetrofitInstance(String BASE_URL) {
        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        // new OkHttpClient()

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    public static String getURL() {
        return URL;
    }
}