package com.dreamlight.saku.ui.jadwal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamlight.saku.Item_Jadwal_hari;
import com.dreamlight.saku.R;

import java.util.ArrayList;

public class JadwalHariFragment extends Fragment {
    private ArrayList<Item_Jadwal_hari> mJadwalHariList;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapater;
    private RecyclerView.LayoutManager mLayoutManager;
    private String hari;

    public JadwalHariFragment(String hari) {
        this.hari = hari;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal_hari,container,false);
        CreateList(hari);
        mRecycleView = view.findViewById(R.id.RV_jadwal_hari);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapater = new JadwalAdapter(mJadwalHariList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapater);
        return view;

    }

    void CreateList(String mHari){
        mJadwalHariList = new ArrayList<>();
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
    }


}
