package com.dreamlight.saku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AbsenKelasInfo extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AbsenKelasInfoAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemEditAbsenKelas> mList;
    private TextView jumlah,hadir,ijin,sakit,alpha;
    private Button edit_btn,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_kelas_info);
        AddList();
        declare();
        CekJumlah();
        recyclerView = findViewById(R.id.RV_absen_info);
        recyclerView.setHasFixedSize(true);
        mAdapter = new AbsenKelasInfoAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AbsenKelasInfo.this,AbsenKelas.class);
                startActivity(i);
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    void AddList(){
        ArrayList<ItemEditAbsenKelas> listHadir= new ArrayList<>();
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        listHadir.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Hadir"));
        ArrayList<ItemEditAbsenKelas> listSakit = new ArrayList<>();
        listSakit.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Sakit"));
        ArrayList<ItemEditAbsenKelas> listIjin = new ArrayList<>();
        listIjin.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Ijin"));
        ArrayList<ItemEditAbsenKelas> listAlpha = new ArrayList<>();
        listAlpha.add(new ItemEditAbsenKelas("gambar","Nama Siswa","916720018545","Alpha"));
        mList = new ArrayList<>();
        mList.addAll(listAlpha);
        mList.addAll(listSakit);
        mList.addAll(listIjin);
        mList.addAll(listHadir);
    }
    void declare(){
        hadir = findViewById(R.id.absen_info_hadir);
        sakit = findViewById(R.id.absen_info_sakit);
        ijin = findViewById(R.id.absen_info_ijin);
        alpha = findViewById(R.id.absen_info_alpha);
        edit_btn = findViewById(R.id.edit_absen_kelas);
        back_btn = findViewById(R.id.back_btn_absen_info);
    }
    void CekJumlah(){
        int jum_hadir=0;
        int jum_sakit=0;
        int jum_ijin=0;
        int jum_alpha=0;
        for (int i=0;i<mList.size();i++){
            if(mList.get(i).getKeterangan_siswa() == "Alpha"){
                jum_alpha = jum_alpha+1;
            }else if(mList.get(i).getKeterangan_siswa() == "Ijin"){
                jum_ijin = jum_ijin+1;
            }else if(mList.get(i).getKeterangan_siswa() == "Sakit"){
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
}
