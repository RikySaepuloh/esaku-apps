package com.dreamlight.saku.ui.jadwal_sekarang;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Jadwal_Sekarang;
import com.dreamlight.saku.R;
import com.dreamlight.saku.model.JadwalSekarang.JadwalSekarangModel;

import java.util.ArrayList;

public class JadwalSekarangAdapter extends RecyclerView.Adapter<JadwalSekarangAdapter.JadwalSekarangViewHolder> {

    private ArrayList<JadwalSekarangModel> mJadwalSekarangList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onMulaiClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public static class JadwalSekarangViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView nama_kelas;
        public TextView jam;
        public TextView matapelajaran;
        public TextView status;
        public Button btnMulai;
        public RelativeLayout headCard;
        public JadwalSekarangViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.icon_status);
            nama_kelas = itemView.findViewById(R.id.nama_kelas);
            jam = itemView.findViewById(R.id.jam);
            matapelajaran = itemView.findViewById(R.id.mataplejaran);
            status = itemView.findViewById(R.id.status);
            btnMulai=itemView.findViewById(R.id.btn_mulai_kelas);
            headCard = itemView.findViewById(R.id.kelas_jam);
            btnMulai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position =getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onMulaiClick(position);
                        }
                    }
//                    mImageView.setImageResource(R.drawable.ic_aktiv_mengajar);
//                    status.setText("Aktif");
//                    nama_kelas.setTextColor(Color.WHITE);
//                    jam.setTextColor(Color.WHITE);
//                    headCard.setBackgroundColor(Color.parseColor("#007AFF"));
                }
            });
        }
    }

    public JadwalSekarangAdapter(ArrayList<JadwalSekarangModel> JadwalSekarangList){
        mJadwalSekarangList = JadwalSekarangList;
    }

    @NonNull
    @Override
    public JadwalSekarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_jadwal_sekarang,parent,false);
        JadwalSekarangViewHolder JSV = new JadwalSekarangViewHolder(v,mListener);
        return JSV;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSekarangViewHolder holder, int position) {
        JadwalSekarangModel items = mJadwalSekarangList.get(position);
        holder.nama_kelas.setText(items.getKode_kelas());
        holder.jam.setText(items.getJam1().substring(0,5)+" - "+items.getJam2().substring(0,5));
        holder.matapelajaran.setText(items.getMatpel());
        holder.status.setText(items.getStatus());
        holder.btnMulai.setVisibility(View.GONE);
        if(items.getStatus() == "Tidak Hadir"){
            holder.mImageView.setImageResource(R.drawable.ic_tidak_hadir);
            holder.status.setText(items.getStatus());
            holder.status.setTextColor(Color.RED);
        }else if(items.getStatus() == "Selesai"){
            holder.mImageView.setImageResource(R.drawable.ic_selesai);
            holder.status.setText(items.getStatus());
            holder.status.setTextColor(Color.parseColor("#007AFF"));
        }else if(items.getStatus() == "Aktif Mengajar"){
            holder.mImageView.setImageResource(R.drawable.ic_aktiv_mengajar);
            holder.status.setText(items.getStatus());
            holder.nama_kelas.setTextColor(Color.WHITE);
            holder.jam.setTextColor(Color.WHITE);
            holder.headCard.setBackgroundColor(Color.parseColor("#007AFF"));

        }else{
            holder.status.setTextColor(Color.parseColor("#4CD964"));
            holder.mImageView.setImageResource(R.drawable.ic_belum_dimulai);
            holder.status.setText("Belum Dimulai");
            holder.status.setTextColor(Color.parseColor("#607D8B"));
            holder.btnMulai.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mJadwalSekarangList.size();
    }
}
