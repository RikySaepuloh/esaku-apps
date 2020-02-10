package com.dreamlight.saku.ui.jadwal;

import android.content.Context;
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
import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.api.UtilsApi;
import com.dreamlight.saku.model.Jadwal.JadwalListModel;
import com.dreamlight.saku.model.Jadwal.JadwalModel;
import com.dreamlight.saku.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalHariFragment extends Fragment {
    private ArrayList<Item_Jadwal_hari> mJadwalHariList;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapater;
    private RecyclerView.LayoutManager mLayoutManager;
    private String hari;
    private ApiService apiService;
    private Preferences sp;
    private Context context;


    public JadwalHariFragment(String hari) {
        this.hari = hari;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal_hari,container,false);
//        CreateList(hari);
        context = view.getContext();
        apiService = UtilsApi.getAPIService(context);
        sp = new Preferences(context);
        getJadwal(hari);
        mRecycleView = view.findViewById(R.id.RV_jadwal_hari);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());

        return view;

    }

    void CreateList(String mHari){
        mJadwalHariList = new ArrayList<>();
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
        mJadwalHariList.add(new Item_Jadwal_hari("XI-IPA-1",mHari,"07:00","09:00"));
    }
    void getJadwal(final String day){
        apiService.getJadwalHari(sp.getKodePP(),sp.getLokasi(),"2021/2022",sp.getUserLog())
                .enqueue(new Callback<JadwalListModel>() {
                    @Override
                    public void onResponse(Call<JadwalListModel> call, Response<JadwalListModel> response) {
                        if(response.body().isStatus()){
                            List<JadwalModel> listJadwal = response.body().getDaftar();
                            mJadwalHariList = new ArrayList<>();
                            for (int i = 0;i<listJadwal.size();i++){
                                if(Integer.parseInt(listJadwal.get(i).getKode_hari()) == Integer.parseInt(day)){
                                    mJadwalHariList.add(new Item_Jadwal_hari(listJadwal.get(i).getKode_kelas(),listJadwal.get(i).getNama_matpel(),listJadwal.get(i).getJam1().substring(0,5),listJadwal.get(i).getJam2().substring(0,5)));
                                }
                            }
                            mAdapater = new JadwalAdapter(mJadwalHariList);
                            mRecycleView.setLayoutManager(mLayoutManager);
                            mRecycleView.setAdapter(mAdapater);
                        }
                    }

                    @Override
                    public void onFailure(Call<JadwalListModel> call, Throwable t) {

                    }
                });
    }


}
