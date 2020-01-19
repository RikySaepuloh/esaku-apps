package com.dreamlight.saku.ui.aktivitas_menagajar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.AbsenKelas;
import com.dreamlight.saku.AbsenKelasInfo;
import com.dreamlight.saku.BuatPesan;
import com.dreamlight.saku.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AktivitasMengajarFragment extends Fragment {
    public ArrayList<ItemListPesan> mList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
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
        Button btn = view.findViewById(R.id.absen_btn);
        Button alpha = view.findViewById(R.id.siswa_alpha_txt);
        Button ijin = view.findViewById(R.id.siswa_ijin_txt);
        Button sakit = view.findViewById(R.id.siswa_sakit_txt);
        Button hadir = view.findViewById(R.id.siswa_hadir_txt);
        LinearLayout aLinear = view.findViewById(R.id.absen_linear);
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
}
