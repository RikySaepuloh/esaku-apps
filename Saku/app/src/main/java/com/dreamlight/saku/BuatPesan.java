package com.dreamlight.saku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.dreamlight.saku.ui.aktivitas_menagajar.AktivitasMengajarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BuatPesan extends AppCompatActivity {
    Spinner tujuan;
    Spinner kepada;
    Button back_btn,btn_kirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesan);
        back_btn = findViewById(R.id.back_btn_tambah_pesan);
        btn_kirim = findViewById(R.id.btn_kirim_pesan);
        tujuan = findViewById(R.id.tujuan);
        kepada = findViewById(R.id.spinner_kepada);
        List<String> list_kepada = new ArrayList<>();
        list_kepada.add("Kelas X-IPA-1");
        list_kepada.add("Kelas X-IPA-2");
        list_kepada.add("Kelas X-IPA-3");
        list_kepada.add("Kelas XI-IPA-1");
        ArrayAdapter<String> kepadaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list_kepada);
        kepadaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kepada.setAdapter(kepadaAdapter);
        List<String> list_tujuan = new ArrayList<>();
        list_tujuan.add("Tugas");
        list_tujuan.add("Pesan");
        list_tujuan.add("Lainnya");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list_tujuan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tujuan.setAdapter(adapter);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(BuatPesan.this, bottom_navigation.class);
                is.putExtra("judul","Tugas Individu");
                is.putExtra("tujuan","Tugas");
                is.putExtra("tgl","31/12/2019");
                is.putExtra("jam","10:39");

            }
        });
    }
}
