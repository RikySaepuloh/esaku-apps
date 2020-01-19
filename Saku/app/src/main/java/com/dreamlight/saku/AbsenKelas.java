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

public class AbsenKelas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AbsenKelasEditAdapter mVHolder;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemEditAbsenKelas> mList;
    private Button back_btn,selesai_btn;
    private TextView jumlah,hadir,ijin,sakit,alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_kelas);
        AddList();
        jumlah = findViewById(R.id.absen_jumlah);
        jumlah.setText(""+mList.size());
        Declare();
        CekJumlah();
        selesai_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
                i.putExtra("hadir",hadir.getText().toString());
                i.putExtra("ijin",ijin.getText().toString());
                i.putExtra("sakit",sakit.getText().toString());
                i.putExtra("alpha",alpha.getText().toString());
                startActivity(i);
            }
        });
        recyclerView = findViewById(R.id.RV_absen_edit);
        recyclerView.setHasFixedSize(true);
        mVHolder = new AbsenKelasEditAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mVHolder);
        mVHolder.SetOnItemClickListener(new AbsenKelasEditAdapter.OnItemClickListener() {
            @Override
            public void OnAlphaClick(int position) {
                DataChange(position,"Alpha");
            }

            @Override
            public void OnIjinClick(int position) {
                DataChange(position,"Ijin");
            }

            @Override
            public void OnSakitClick(int position) {
                DataChange(position,"Sakit");
            }
        });
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

        }else {
            mList.get(position).setKeterangan_siswa("Hadir");
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

    void Declare(){
        hadir = findViewById(R.id.absen_hadir);
        sakit = findViewById(R.id.absen_sakit);
        ijin = findViewById(R.id.absen_ijin);
        alpha = findViewById(R.id.absen_alpha);
        selesai_btn = findViewById(R.id.btn_simpan_absen);
    }
}
