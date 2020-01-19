package com.dreamlight.saku.ui.notifications;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Notifikasi;
import com.dreamlight.saku.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {


    private ArrayList<Item_Notifikasi> mNotifList;
    private RecyclerView mRecycleView;
    private NotifikasiAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        androidx.appcompat.widget.Toolbar toolbar =  view.findViewById(R.id.tnotif);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        CreateList();
        mRecycleView = view.findViewById(R.id.RV_notifikasi);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new NotifikasiAdapter(mNotifList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new NotifikasiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });
        return view;
    }

    void CreateList(){
        mNotifList = new ArrayList<>();
        mNotifList.add(new Item_Notifikasi("20 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi","Belum Dibaca"));
        mNotifList.add(new Item_Notifikasi("20 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Belum Dibaca"));
        mNotifList.add(new Item_Notifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));
        mNotifList.add(new Item_Notifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));
        mNotifList.add(new Item_Notifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));

    }
}