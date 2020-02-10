package com.dreamlight.saku.ui.jadwal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dreamlight.saku.ui.aktivitas_menagajar.AktivitasMengajarFragment;
import com.dreamlight.saku.ui.home.HomeFragment;
import com.dreamlight.saku.ui.jadwal_sekarang.JadwalSekarangFragment;

public class JadwalViewPagerAdapter extends FragmentPagerAdapter {

    public JadwalViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                String senin = "Senin";
                return senin;
            case 1:
                String selasa = "Selasa";
                return  selasa;
            case 2:
                String rabu = "Rabu";
                return  rabu;
            case 3:
                String kamis = "Kamis";
                return  kamis;
            case 4:
                String jumat = "Jumat";
                return  jumat;
            case 5:
                String sabtu = "Sabtu";
                return  sabtu;
        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new JadwalHariFragment("1");
            case 1:
                return  new JadwalHariFragment("2");
            case 2:
                return  new JadwalHariFragment("3");
            case 3:
                return  new JadwalHariFragment("4");
            case 4:
                return  new JadwalHariFragment("5");
            case 5:
                return  new JadwalHariFragment("6");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }

    void getJadwal(){

    }
}
