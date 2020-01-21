package com.dreamlight.saku.api;

import android.content.Context;

public class UtilsApi {


    // Ini untuk base url nya
    public static final String BASE_URL_API = "http://saiweb.simkug.com/api/siswa/";

    // Mendeklarasikan Interface BaseApiService\
    public static ApiService getAPIService(Context context){
       return RetofitClient.getCLient(BASE_URL_API,context).create(ApiService.class);
    }
}