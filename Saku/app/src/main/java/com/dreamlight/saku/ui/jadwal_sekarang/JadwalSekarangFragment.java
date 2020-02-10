package com.dreamlight.saku.ui.jadwal_sekarang;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Jadwal_Sekarang;
import com.dreamlight.saku.MainActivity;
import com.dreamlight.saku.R;
import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.api.UtilsApi;
import com.dreamlight.saku.model.JadwalSekarang.JadwalSekarangModel;
import com.dreamlight.saku.model.JadwalSekarang.ListJadwalSekarangModel;
import com.dreamlight.saku.preferences.Preferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSekarangFragment extends Fragment {
private RecyclerView mRecycleView;
private JadwalSekarangAdapter mAdapter;
    private ApiService apiService;
    private Context context;
    private Preferences sp;
    private ProgressBar progress;
    private TextView hari,tanggal;
    private Integer kodes;
    private String tang;
private RecyclerView.LayoutManager mLayoutManager;
private ArrayList<Item_Jadwal_Sekarang> mjadwalSekarangList;
private ArrayList<JadwalSekarangModel> mJadwalSekarangModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jadwal_sekarang,container,false);
        hari = view.findViewById(R.id.hari);
        tanggal = view.findViewById(R.id.tanggal);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String[] date=currentDate.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String tgl = sdf.format(calendar.getTime());
        hari.setText(date[0]);
        tanggal.setText(tgl);
        tang = tgl;
        context = view.getContext();
        sp = new Preferences(context);
        apiService = UtilsApi.getAPIService(context);
        progress = view.findViewById(R.id.progres_jadwal_sekarang);
        getJadwalSekarang(date[0]);
        mRecycleView = view.findViewById(R.id.RV_jadwal_sekarang);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());


        return view;
    }

    void ShowDialog(int pos){
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View v = inflater.inflate(R.layout.alert_dialog_mulai,null);
        TextView mulai = v.findViewById(R.id.btn_mulai_alert);
        TextView batal = v.findViewById(R.id.btn_batal_alert);
        final int position = pos;

        final AlertDialog alertDialog = new AlertDialog.Builder(this.getContext())
                .setView(v)
                .create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();
        alertDialog.getWindow().setLayout(700,300);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJadwalSekarangModel.get(position).setStatus("Aktif Mengajar");
                mAdapter.notifyItemChanged(position);
                alertDialog.dismiss();
                sp.setKelas(mJadwalSekarangModel.get(position).getKode_kelas());
                sp.setJam(mJadwalSekarangModel.get(position).getJam1());
                String[] dates = tang.split("/");
                sp.setDate(dates[2]+"-"+dates[1]+"-"+dates[0]);
            }
        });
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

            }
        });
    }


    void getJadwalSekarang(String hari){
        Integer kode=0;
        String[] haris = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"};
        for (int i=0;i<haris.length;i++){
            if(haris[i].equals(hari)){
                kode = i+1;
            }
            Log.i("Tester",haris[i]+" = "+hari);
        }
        progress.setVisibility(View.VISIBLE);
        apiService.getJadwalSekarang(sp.getKodePP(),"2021/2022",sp.getUserLog(),kode.toString(),sp.getLokasi())
                .enqueue(new Callback<ListJadwalSekarangModel>() {
                    @Override
                    public void onResponse(Call<ListJadwalSekarangModel> call, Response<ListJadwalSekarangModel> response) {
                        if (response.body().isStatus()){
                            List<JadwalSekarangModel> listJadwalSekarang = response.body().getDaftar();
                            mJadwalSekarangModel = new ArrayList<>();
                            for (int i =0; i < listJadwalSekarang.size();i++){
                                mJadwalSekarangModel.add(new JadwalSekarangModel(
                                        listJadwalSekarang.get(i).getKode_kelas(),
                                        listJadwalSekarang.get(i).getKode_matpel(),
                                        listJadwalSekarang.get(i).getJam1(),
                                        listJadwalSekarang.get(i).getJam2(),
                                        listJadwalSekarang.get(i).getMatpel(),
                                        listJadwalSekarang.get(i).getStatus()
                                ));
                            }
                            mAdapter = new JadwalSekarangAdapter(mJadwalSekarangModel);
                            mRecycleView.setLayoutManager(mLayoutManager);
                            mRecycleView.setAdapter(mAdapter);
                            mAdapter.setOnItemClickListener(new JadwalSekarangAdapter.OnItemClickListener() {
                                @Override
                                public void onMulaiClick(int position) {
                                    ShowDialog(position);
                                }
                            });
                            progress.setVisibility(View.GONE);

                        }else {
                            Toast.makeText(context,"Server Bermasalah",Toast.LENGTH_SHORT);
                            progress.setVisibility(View.GONE);

                        }
                    }

                    @Override
                    public void onFailure(Call<ListJadwalSekarangModel> call, Throwable t) {

                    }
                });
    }
}
