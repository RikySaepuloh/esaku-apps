package com.dreamlight.saku.ui.jadwal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Jadwal_hari;
import com.dreamlight.saku.R;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private ArrayList<Item_Jadwal_hari> mJadwalHariList;

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_jadwal_hari,parent,false);
        JadwalViewHolder JVH = new JadwalViewHolder(v);
        return JVH;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        Item_Jadwal_hari item = mJadwalHariList.get(position);
        holder.kelas.setText(item.getNama_kelas());
        holder.matapelajaran.setText(item.getMatapelajaran());
        holder.jammulai.setText(item.getJammulai());
        holder.jamselesai.setText(item.getJamsampai());
    }

    @Override
    public int getItemCount() {
        return mJadwalHariList.size();
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder{
        public TextView kelas;
        public TextView matapelajaran;
        public TextView jammulai;
        public TextView jamselesai;
        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            kelas = itemView.findViewById(R.id.nama_kelas_jadwal_hari);
            matapelajaran = itemView.findViewById(R.id.mataplejaran_jadwal_hari);
            jammulai = itemView.findViewById(R.id.jam_mulai);
            jamselesai=itemView.findViewById(R.id.jam_selesai);
        }
    }

    public JadwalAdapter(ArrayList<Item_Jadwal_hari> JadwalHariList){
        mJadwalHariList = JadwalHariList;
    }
}
