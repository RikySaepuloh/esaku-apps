package com.dreamlight.saku.ui.home;

import android.content.Context;
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
import androidx.viewpager.widget.ViewPager;

import com.dreamlight.saku.R;
import com.dreamlight.saku.api.ApiService;
import com.dreamlight.saku.preferences.Preferences;
import com.dreamlight.saku.ui.aktivitas_menagajar.AktivitasMengajarFragment;
import com.dreamlight.saku.ui.jadwal_sekarang.JadwalSekarangFragment;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView nama;
    private CircleImageView profile_image;
    private Preferences sp;
    private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_home, container, false);
        final TabLayout tabs = (TabLayout) view.findViewById(R.id.tab_nav_home);
        final ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setupWithViewPager(viewPager);
            }
        });
        nama = view.findViewById(R.id.nama_pengguna);
        profile_image = view.findViewById(R.id.profile_image);
        context = view.getContext();
        sp = new Preferences(context);
        nama.setText(sp.getNamaUser());
        Picasso.get().load("http://saiweb.simkug.com/upload/"+sp.getFoto().toString()).placeholder(R.drawable.bussiness)
                .error(R.drawable.bussiness).into(profile_image);
        return view;

    }



}