package com.dreamlight.saku.ui.aktivitas_menagajar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.AbsenKelas;
import com.dreamlight.saku.AbsenKelasInfo;
import com.dreamlight.saku.BuatPesan;
import com.dreamlight.saku.R;
import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.api.UtilsApi;
import com.dreamlight.saku.model.AbsenKelas.AbsenKelasList;
import com.dreamlight.saku.model.AbsenKelas.AbsenKelasModel;
import com.dreamlight.saku.preferences.Preferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AktivitasMengajarFragment extends Fragment {
    public ArrayList<ItemListPesan> mList;
    private Preferences sp;
    private Context context;
    private ApiService apiService;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private CardView aktivitas_card;
    private View view;
    private Button btn,ijin,sakit,alpha,hadir;
    private LinearLayout aLinear;
    private TextView kelas_jumlah,tanggal,jam;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aktivitas_mengajar,container,false);
        FloatingActionButton fab_pesan = view.findViewById(R.id.fab_pesan);
        fab_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), BuatPesan.class);
                startActivity(i);
            }
        });
        aktivitas_card = view.findViewById(R.id.card_view_aktivitas);
        btn = view.findViewById(R.id.absen_btn);
        alpha = view.findViewById(R.id.siswa_alpha_txt);
        ijin = view.findViewById(R.id.siswa_ijin_txt);
        sakit = view.findViewById(R.id.siswa_sakit_txt);
        hadir = view.findViewById(R.id.siswa_hadir_txt);
        kelas_jumlah = view.findViewById(R.id.kelas_jumlah);
        tanggal = view.findViewById(R.id.absen_kelas_list_tgl);
        jam = view.findViewById(R.id.absen_kelas_list_jam);
        aLinear = view.findViewById(R.id.absen_linear);
        context = view.getContext();
        sp = new Preferences(context);
        apiService = UtilsApi.getAPIService(context);
        getData();
        if (savedInstanceState == null){ ;
           Bundle bundel = getActivity().getIntent().getExtras();
           if(bundel == null){
            aLinear.setVisibility(View.GONE);
           }else{
               btn.setVisibility(View.GONE);
               alpha.setText(bundel.getString("alpha"));
               ijin.setText(bundel.getString("ijin"));
               sakit.setText(bundel.getString("sakit"));
               hadir.setText(bundel.getString("hadir"));
               makeList();
               makeRecycle();
           }
        }

        aLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), AbsenKelasInfo.class);
                startActivity(in);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AbsenKelas.class);
                startActivity(i);
            }
        });

        return view;
    }
    void makeList(){
        mList = new ArrayList<>();
        mList.add(new ItemListPesan("Tugas Individu","Kelas X-IPA-1","Tugas","31/12/2019","10:39","Deskripsi ini dari notifikasi yang akan disampaikan kepada penerima notifikasi"));
    }
    void makeRecycle(){
        recyclerView = view.findViewById(R.id.RV_pesan_list);
        recyclerView.setHasFixedSize(true);
        mAdapter = new PesanListAdapter(mList,this.getContext());
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    void getData(){
        apiService.getAbsenKelas(sp.getKodePP(),sp.getLokasi(),"2021/2022",sp.getUserLog(),"2","07:30:00","2020-02-15")
                .enqueue(new Callback<AbsenKelasList>() {
                    @Override
                    public void onResponse(Call<AbsenKelasList> call, Response<AbsenKelasList> response) {
                        if(response.body().isStatus()){
                            List<AbsenKelasModel> listAbsenKelas= response.body().getDaftar();
                            for (int i=0;i<listAbsenKelas.size();i++){
                                kelas_jumlah.setText(listAbsenKelas.get(i).getKode_kelas()+"|"+listAbsenKelas.get(i).getJum_sis());
//                                tanggal.setText(sp.getDate());
//                                jam.setText(sp.getJam());
                                if (listAbsenKelas.get(i).getJum_hadir().equals("0")){
                                    aLinear.setVisibility(View.GONE);
                                }else{
                                    btn.setVisibility(View.GONE);
                                    aLinear.setVisibility(View.VISIBLE);
                                    hadir.setText(listAbsenKelas.get(i).getJum_hadir());
                                    ijin.setText(listAbsenKelas.get(i).getJum_izin());
                                    sakit.setText(listAbsenKelas.get(i).getJum_sakit());
                                    alpha.setText(listAbsenKelas.get(i).getJum_alpa());
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AbsenKelasList> call, Throwable t) {

                    }
                });
    }
}
