package com.dreamlight.saku.ui.jadwal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.dreamlight.saku.Item_Jadwal_hari;
import com.dreamlight.saku.R;
import com.dreamlight.saku.ui.home.HomeViewModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class JadwalFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
    ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);
        final TabLayout tabs = (TabLayout) view.findViewById(R.id.tab_jadwal_hari);
        final ViewPager vP = (ViewPager) view.findViewById(R.id.viewPager_jadwal);
        vP.setAdapter(new JadwalViewPagerAdapter(getChildFragmentManager()));
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setupWithViewPager(vP);
            }
        });
        return view;
    }




}
