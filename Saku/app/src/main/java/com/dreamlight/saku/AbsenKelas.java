package com.dreamlight.saku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.api.UtilsApi;
import com.dreamlight.saku.model.AbsenKelas.AbsenSimpanDataModel;
import com.dreamlight.saku.model.AbsenKelas.DetailAbsenModel;
import com.dreamlight.saku.model.AbsenKelas.SimpanAbsenModel;
import com.dreamlight.saku.model.DaftarSiswa.DaftarSiswaListModel;
import com.dreamlight.saku.model.DaftarSiswa.DaftarSiswaModel;
import com.dreamlight.saku.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsenKelas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AbsenKelasEditAdapter mVHolder;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemEditAbsenKelas> mList;
    private Button back_btn,selesai_btn;
    private TextView jumlah,hadir,ijin,sakit,alpha;
    private ApiService apiService;
    private Preferences sp;
    private Context context;
    private ArrayList<DetailAbsenModel> detailAbsens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_kelas);
        context = this;
        apiService = UtilsApi.getAPIService(context);
        sp = new Preferences(context);
        getDaftarSiswa();
//        AddList();
        jumlah = findViewById(R.id.absen_jumlah);



        recyclerView = findViewById(R.id.RV_absen_edit);
        recyclerView.setHasFixedSize(true);

        back_btn = findViewById(R.id.back_btn_absen);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void DataChange(int position, String keterangan){
        if(mList.get(position).getKeterangan_siswa() != keterangan){
            mList.get(position).setKeterangan_siswa(keterangan);
            detailAbsens.get(position).setStatus(keterangan);

        }else {
            mList.get(position).setKeterangan_siswa("Hadir");
            detailAbsens.get(position).setStatus(keterangan);
        }
            mVHolder.notifyItemChanged(position);
            CekJumlah();
    }

    void AddList(){
        mList = new ArrayList<>();
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Alpha"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Ijin"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        mList.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Sakit"));
    }

    void CekJumlah(){
       int jum_hadir=0;
        int jum_sakit=0;
        int jum_ijin=0;
        int jum_alpha=0;
        for (int i=0;i<mList.size();i++){
            if(mList.get(i).getKeterangan_siswa() == "alpa"){
                jum_alpha = jum_alpha+1;
            }else if(mList.get(i).getKeterangan_siswa() == "ijin"){
                jum_ijin = jum_ijin+1;
            }else if(mList.get(i).getKeterangan_siswa() == "sakit"){
                jum_sakit = jum_sakit+1;
            }else{
                jum_hadir = jum_hadir+1;
            }
        }
        hadir.setText(""+jum_hadir);
        ijin.setText(""+jum_ijin);
        sakit.setText(""+jum_sakit);
        alpha.setText(""+jum_alpha);
    }

    void Declare(){
        hadir = findViewById(R.id.absen_hadir);
        sakit = findViewById(R.id.absen_sakit);
        ijin = findViewById(R.id.absen_ijin);
        alpha = findViewById(R.id.absen_alpha);
        selesai_btn = findViewById(R.id.btn_simpan_absen);
    }

    void getDaftarSiswa(){
        apiService.getDaftarSiswa(sp.getKodePP(),sp.getLokasi(),"XI-13RPL")
                .enqueue(new Callback<DaftarSiswaListModel>() {
                    @Override
                    public void onResponse(Call<DaftarSiswaListModel> call, Response<DaftarSiswaListModel> response) {
                        if(response.body().isStatus()){
                            mList = new ArrayList<>();
                            detailAbsens = new ArrayList<>();
                            List<DaftarSiswaModel> listSiswa = response.body().getDaftar();
                            for (int i=0;i<listSiswa.size();i++){
                                mList.add(new ItemEditAbsenKelas("gambar", listSiswa.get(i).getNama(),listSiswa.get(i).getNis(),listSiswa.get(i).getSts()));
                                detailAbsens.add(new DetailAbsenModel(listSiswa.get(i).getNis(),listSiswa.get(i).getSts()));
                            }
                            Declare();
                            CekJumlah();
                            selesai_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
//                                    Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
//                                    i.putExtra("hadir",hadir.getText().toString());
//                                    i.putExtra("ijin",ijin.getText().toString());
//                                    i.putExtra("sakit",sakit.getText().toString());
//                                    i.putExtra("alpha",alpha.getText().toString());
//                                    startActivity(i);
                                    SimpanAbsen();
                                }
                            });
                            jumlah.setText(""+mList.size());
                            mVHolder = new AbsenKelasEditAdapter(mList);
                            layoutManager = new LinearLayoutManager(context);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(mVHolder);
                            mVHolder.SetOnItemClickListener(new AbsenKelasEditAdapter.OnItemClickListener() {
                                @Override
                                public void OnAlphaClick(int position) {
                                    DataChange(position,"alpa");
                                }

                                @Override
                                public void OnIjinClick(int position) {
                                    DataChange(position,"ijin");
                                }

                                @Override
                                public void OnSakitClick(int position) {
                                    DataChange(position,"sakit");
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<DaftarSiswaListModel> call, Throwable t) {

                    }
                });
    }

    void SimpanAbsen(){
        apiService.simpanAbsen(new AbsenSimpanDataModel(sp.getKodePP(),sp.getLokasi(),"XI-13RPL","BIN","2020-02-15",1,"2021/2022",sp.getUserLog(),detailAbsens))
                .enqueue(new Callback<SimpanAbsenModel>() {
                    @Override
                    public void onResponse(Call<SimpanAbsenModel> call, Response<SimpanAbsenModel> response) {
                        Log.i("Response",response.message());
                        Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<SimpanAbsenModel> call, Throwable t) {
                        Log.i("Response","error");
                    }
                });
    }
}
