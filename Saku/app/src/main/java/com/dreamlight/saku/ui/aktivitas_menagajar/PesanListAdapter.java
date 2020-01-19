package com.dreamlight.saku.ui.aktivitas_menagajar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.LihatPesan;
import com.dreamlight.saku.R;

import java.util.ArrayList;

public class PesanListAdapter extends RecyclerView.Adapter<PesanListAdapter.PesanListViewHolder> {
    public ArrayList<ItemListPesan> mList;
    private Context cons;
    @NonNull
    @Override
    public PesanListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_pesan,parent,false);
        PesanListViewHolder PLVH = new PesanListViewHolder(view);
        return PLVH;
    }

    @Override
    public void onBindViewHolder(@NonNull PesanListViewHolder holder, int position) {
        ItemListPesan item = mList.get(position);
        holder.judul.setText(item.getJudul());
        holder.tanggal.setText(item.getTanggal());
        holder.jam.setText(item.getJam());
        holder.btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cons, LihatPesan.class);
                cons.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class  PesanListViewHolder extends RecyclerView.ViewHolder {
        public TextView judul,tanggal,jam;
        public Button btn_lihat;
        public PesanListViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.pesan_list_judul);
            tanggal = itemView.findViewById(R.id.pesan_list_tgl);
            jam=  itemView.findViewById(R.id.pesan_list_jam);
            btn_lihat = itemView.findViewById(R.id.lihat_btn);
        }
    }

    public PesanListAdapter(ArrayList<ItemListPesan> list, Context con){
        mList=list;
        cons=con;
    }
}
