package com.dreamlight.saku.api;

import com.dreamlight.saku.Login;
import com.dreamlight.saku.model.kodePPModel;
import com.dreamlight.saku.model.loginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Login.php?fx=login")
    Call<loginModel> login (
        @Field("nik") String nik,
        @Field("pass") String pass,
        @Field("kode_pp") String kode_pp
            );

    @FormUrlEncoded
    @POST("Login.php?fx=getDaftarPP")
    Call<kodePPModel> getPP (
        @Field("nis") String nik
    );
}
