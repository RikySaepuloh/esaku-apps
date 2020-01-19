package com.dreamlight.saku;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AbsenKelasInfoAdapter extends RecyclerView.Adapter<AbsenKelasInfoAdapter.AbsenKelasInfoViewHolder> {
    public ArrayList<ItemEditAbsenKelas> mlist;
    public String keterangan="";
    @NonNull
    @Override
    public AbsenKelasInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_absen_kelas_info,parent,false);
        AbsenKelasInfoViewHolder AKIV = new AbsenKelasInfoViewHolder(view);
        return AKIV;
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenKelasInfoViewHolder holder, int position) {

        ItemEditAbsenKelas item = mlist.get(position);
        holder.nama_siswa.setText(item.getNama_siswa());
        holder.nis_siswa.setText(item.getNis_siswa());
        if(item.getKeterangan_siswa() == "Sakit"){
            holder.ijin_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.ijin_btn.setTextColor(Color.GRAY);
            holder.alpha_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.alpha_btn.setTextColor(Color.GRAY);
            holder.sakit_btn.setBackgroundResource(R.drawable.sakit_background);
            holder.sakit_btn.setTextColor(Color.WHITE);
        }else if(item.getKeterangan_siswa() == "Ijin"){
            holder.alpha_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.alpha_btn.setTextColor(Color.GRAY);
            holder.sakit_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.sakit_btn.setTextColor(Color.GRAY);
            holder.ijin_btn.setBackgroundResource(R.drawable.ijin_background);
            holder.ijin_btn.setTextColor(Color.WHITE);
        }else if(item.getKeterangan_siswa() == "Alpha"){
            holder.sakit_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.sakit_btn.setTextColor(Color.GRAY);
            holder.ijin_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.ijin_btn.setTextColor(Color.GRAY);
            holder.alpha_btn.setBackgroundResource(R.drawable.alpha_background);
            holder.alpha_btn.setTextColor(Color.WHITE);
        }else{
            holder.sakit_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.sakit_btn.setTextColor(Color.GRAY);
            holder.alpha_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.alpha_btn.setTextColor(Color.GRAY);
            holder.ijin_btn.setBackgroundResource(R.drawable.hadir_ket_background);
            holder.ijin_btn.setTextColor(Color.GRAY);
        }
        if(item.getKeterangan_siswa() == keterangan){
            holder.txt_keterangan.setVisibility(View.GONE);
        }else {
            holder.txt_keterangan.setText(item.getKeterangan_siswa());
        }
        keterangan=item.getKeterangan_siswa();
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class AbsenKelasInfoViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView siswa_img;
        public TextView nama_siswa;
        public TextView nis_siswa;
        public Button sakit_btn;
        public Button ijin_btn;
        public Button alpha_btn;
        public TextView txt_keterangan;
        public AbsenKelasInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            siswa_img = itemView.findViewById(R.id.siswa_info_img);
            nama_siswa = itemView.findViewById(R.id.nama_siswa_info);
            nis_siswa = itemView.findViewById(R.id.nis_siswa_info);
            sakit_btn = itemView.findViewById(R.id.siswa_sakit_info);
            ijin_btn = itemView.findViewById(R.id.siswa_ijin_info);
            alpha_btn = itemView.findViewById(R.id.siswa_alpha_info);
            txt_keterangan = itemView.findViewById(R.id.txt_keterangan_info);

        }
    }

    public AbsenKelasInfoAdapter (ArrayList<ItemEditAbsenKelas>list){
        mlist=list;
    }
}
