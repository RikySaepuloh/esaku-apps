package com.dreamlight.saku.api;

import android.content.Context;

import com.dreamlight.saku.preferences.Preferences;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetofitClient {

    private static String BASE_URL_API = "http://saiweb.simkug.com/api/siswa/";
    private static Retrofit retrofit= null;

    public static  Retrofit getCLient(String base_url, Context context){
        final Preferences sp = new Preferences(context);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor interceptor1 = new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Accept","application/json")
                        .addHeader("Authorization", sp.getToken())
                        .build();
                return chain.proceed(newRequest);
            }
        };
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor1).addInterceptor(interceptor).build();

        if (retrofit == null){
        retrofit = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
        }
        return retrofit;
    }
}

