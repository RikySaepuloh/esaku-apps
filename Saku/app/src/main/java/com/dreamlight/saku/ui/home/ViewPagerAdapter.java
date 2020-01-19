package com.dreamlight.saku.ui.home;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dreamlight.saku.ui.aktivitas_menagajar.AktivitasMengajarFragment;
import com.dreamlight.saku.ui.jadwal_sekarang.JadwalSekarangFragment;

import java.util.zip.Inflater;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AktivitasMengajarFragment();
            case 1:
                return  new JadwalSekarangFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                String aktivitas_mengajar = "Aktivitas Mengajar";
                return aktivitas_mengajar;
            case 1:
                String jadwal_sekarang = "Jadwal Sekarang";
                return  jadwal_sekarang;
        }
        return null;

    }
}
