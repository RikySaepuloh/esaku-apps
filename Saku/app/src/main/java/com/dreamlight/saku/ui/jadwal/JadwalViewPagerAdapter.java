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
                return new JadwalHariFragment("Bahasa Indonesia");
            case 1:
                return  new JadwalHariFragment("Matematika");
            case 2:
                return  new JadwalHariFragment("Bahasa Inggris");
            case 3:
                return  new JadwalHariFragment("Kimia");
            case 4:
                return  new JadwalHariFragment("Biologi");
            case 5:
                return  new JadwalHariFragment("Fisika");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
