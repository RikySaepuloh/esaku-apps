package com.dreamlight.saku.ui.jadwal_sekarang;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Jadwal_Sekarang;
import com.dreamlight.saku.MainActivity;
import com.dreamlight.saku.R;

import java.util.ArrayList;

public class JadwalSekarangFragment extends Fragment {
private RecyclerView mRecycleView;
private JadwalSekarangAdapter mAdapter;
private RecyclerView.LayoutManager mLayoutManager;
private ArrayList<Item_Jadwal_Sekarang> mjadwalSekarangList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jadwal_sekarang,container,false);
        CreateArray();
        mRecycleView = view.findViewById(R.id.RV_jadwal_sekarang);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new JadwalSekarangAdapter(mjadwalSekarangList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new JadwalSekarangAdapter.OnItemClickListener() {
            @Override
            public void onMulaiClick(int position) {
                Log.i("MainActivity","Kliked");
                ShowDialog();
            }
        });
        return view;
    }

    void ShowDialog(){
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View v = inflater.inflate(R.layout.alert_dialog_mulai,null);
        TextView mulai = v.findViewById(R.id.btn_mulai_alert);
        TextView batal = v.findViewById(R.id.btn_batal_alert);

        final AlertDialog alertDialog = new AlertDialog.Builder(this.getContext())
                .setView(v)
                .create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();
        alertDialog.getWindow().setLayout(700,300);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("diKlik","Mulai");
            }
        });
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

            }
        });
    }

    void CreateArray(){
        mjadwalSekarangList  = new ArrayList<>();
        mjadwalSekarangList.add(new Item_Jadwal_Sekarang("X-IPA-1","07:00 - 09:00","Bahasa Indonesia","Selesai"));
        mjadwalSekarangList.add(new Item_Jadwal_Sekarang("X-IPA-1","09:00 - 11:00","Matematika","Tidak Hadir"));
        mjadwalSekarangList.add(new Item_Jadwal_Sekarang("X-IPA-1","11:00 - 13:00","Bahasa Inggris","Selesai"));
        mjadwalSekarangList.add(new Item_Jadwal_Sekarang("X-IPA-1","13:00 - 15:00","Matematika","Aktif Mengajar"));
        mjadwalSekarangList.add(new Item_Jadwal_Sekarang("X-IPA-1","15:00 - 17:00","Sejarah","Belum dimulai"));

    }
}
