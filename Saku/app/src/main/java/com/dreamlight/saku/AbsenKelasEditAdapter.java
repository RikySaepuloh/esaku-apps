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

public class AbsenKelasEditAdapter extends RecyclerView.Adapter<AbsenKelasEditAdapter.AbsenKelasEditViewHolder> {
    private ArrayList<ItemEditAbsenKelas> mList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void OnAlphaClick(int position);
        void OnIjinClick(int position);
        void OnSakitClick(int position);
    }

    public void SetOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    @NonNull
    @Override
    public AbsenKelasEditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_absen_kelas_edit,parent,false);
        AbsenKelasEditViewHolder AKEV = new AbsenKelasEditViewHolder(view,mListener);
        return AKEV;
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenKelasEditViewHolder holder, int position) {
        ItemEditAbsenKelas item = mList.get(position);
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
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class AbsenKelasEditViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView siswa_img;
        public TextView nama_siswa;
        public TextView nis_siswa;
        public Button sakit_btn;
        public Button ijin_btn;
        public Button alpha_btn;
        public AbsenKelasEditViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            siswa_img = itemView.findViewById(R.id.siswa_img);
            nama_siswa = itemView.findViewById(R.id.nama_siswa_edit);
            nis_siswa = itemView.findViewById(R.id.nis_siswa_edit);
            sakit_btn = itemView.findViewById(R.id.siswa_sakit);
            ijin_btn = itemView.findViewById(R.id.siswa_ijin);
            alpha_btn = itemView.findViewById(R.id.siswa_alpha);
            alpha_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnAlphaClick(position);
                        }
                    }
                }
            });

            ijin_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnIjinClick(position);
                        }
                    }
                }
            });
            sakit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnSakitClick(position);
                        }
                    }
                }
            });

        }
    }

    public AbsenKelasEditAdapter(ArrayList<ItemEditAbsenKelas> list){
        mList = list;
    }
}
