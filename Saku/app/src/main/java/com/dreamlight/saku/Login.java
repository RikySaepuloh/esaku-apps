package com.dreamlight.saku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.api.UtilsApi;
import com.dreamlight.saku.model.PpItemModel;
import com.dreamlight.saku.model.kodePPModel;
import com.dreamlight.saku.model.loginModel;
import com.dreamlight.saku.preferences.Preferences;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private Button btnMasuk;
    private EditText email;
    private TextInputEditText password;
    private ApiService apiService;
    private TextView namapp;
    private Context context;
    private Preferences sp;
    private String kode_pp;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnMasuk = findViewById(R.id.btn_masuk);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        namapp =  findViewById(R.id.nama_pp);
        context = this;
        sp = new Preferences(this);
        apiService = UtilsApi.getAPIService(context);
        if (sp.getIsLogedIn()){
            Intent i = new Intent(context,bottom_navigation.class);
            startActivity(i);
        }

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),namapp.getText().toString(),Toast.LENGTH_LONG).show();
//                Intent i = new Intent(Login.this, bottom_navigation.class);
//                startActivity(i);
                    Dialogs();
                    Login(email.getText().toString(),password.getText().toString(),namapp.getText().toString());
            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    getPP(email.getText().toString());


                }
            }
        });
    }

    void Dialogs(){
        dialog = new ProgressDialog(context);
        dialog.show();
        dialog.setContentView(R.layout.progres_dialog);
        dialog.setCancelable(false);

    }

    void getPP(String nik){
        apiService.getPP(nik)
                .enqueue(new Callback<kodePPModel>() {
                    @Override
                    public void onResponse(Call<kodePPModel> call, Response<kodePPModel> response) {
                        if (response.body().getPp() != null){
                            List<PpItemModel> items =response.body().getPp();
                            for (int i=0;i <items.size();i++){
                                namapp.setText(items.get(i).getKodePp());
                                kode_pp = items.get(i).getKodePp();
                            }
                        }else {
                            Toast.makeText(context, "Tidak ada data", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<kodePPModel> call, Throwable t) {
                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                        Log.i("makan",t.toString());
                    }
                });
    }

    void Login(String nik, String pass, String kode_pp){
            apiService.login(nik,pass,kode_pp)
                    .enqueue(new Callback<loginModel>() {
                        @Override
                        public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                            if(response.body() != null){
                                if(response.body().isIsLogedIn()){
                                    sp.saveUserLog(response.body().getUserLog());
                                    sp.saveUserStatus(response.body().getUserStatus());
                                    sp.saveNamaLokasi(response.body().getNamalokasi());
                                    sp.saveKodePp(response.body().getKodePP());
                                    sp.saveNoHp(response.body().getNoHp());
                                    sp.saveUserPwd(response.body().getUserPwd());
                                    sp.setLoggedStatus(response.body().isIsLogedIn());
                                    sp.saveKodeLokasiKonsol(response.body().getKodeLokasiKonsol());
                                    sp.saveNamaUser(response.body().getNamaUser());
                                    sp.savePeriode(response.body().getPeriode());
                                    sp.saveFormLogin(response.body().getFormLogin());
                                    sp.saveLoginTime(response.body().getLoginTime());
                                    sp.saveLogo(response.body().getLogo());
                                    sp.saveNikUser(response.body().getNikUser());
                                    sp.saveEmail(response.body().getEmail());
                                    sp.saveKodeMenu(response.body().getKodeMenu());
                                    sp.saveToken(response.body().getToken());
                                    sp.saveExitUrl(response.body().getExitUrl());
                                    sp.saveKodeFs(response.body().getKodeFs());
                                    sp.saveHakAkses(response.body().getHakakses());
                                    sp.saveFoto(response.body().getFoto());
                                    sp.saveApiKey(response.body().getApiKey());
                                    sp.saveLokasi(response.body().getLokasi());
                                    sp.saveNamaPp(response.body().getNamaPP());
                                    sp.saveDash(response.body().getDash());
                                    sp.saveKodeBidang(response.body().getKodeBidang());
                                    Intent i = new Intent(Login.this,bottom_navigation.class);
                                    startActivity(i);
                                }else {
                                    Toast.makeText(context,response.body().getMessage().toString(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<loginModel> call, Throwable t) {

                        }
                    });
    }
}
