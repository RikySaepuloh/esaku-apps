package com.dreamlight.saku.ui.pengguna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dreamlight.saku.EditProfile;
import com.dreamlight.saku.Login;
import com.dreamlight.saku.R;
import com.dreamlight.saku.preferences.Preferences;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PenggunaFragment extends Fragment {
    private View view;
    private TextView nama,nik,no_tlp,email,keluar;
    private Context context;
    private Preferences preferences;
    private CircleImageView gambar_profile;

    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pengguna,container,false);
        Toolbar toolbar = view.findViewById(R.id.penggunaToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        Button editBtn = view.findViewById(R.id.btn_edit_pengguna);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), EditProfile.class);
                startActivity(i);
            }
        });
        Declare();
        nama.setText(preferences.getNamaUser());
        nik.setText(preferences.getNikUser());
        no_tlp.setText(preferences.getNoHp());
        email.setText(preferences.getEmail());
        Picasso.get().load("http://saiweb.simkug.com/upload/"+preferences.getFoto())
                .placeholder(R.drawable.bussiness)
                .error(R.drawable.bussiness)
                .into(gambar_profile);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.Logout();
                Intent i = new Intent(context, Login.class);
                startActivity(i);
            }
        });
        return view;

    }

    void Declare(){
        nama = view.findViewById(R.id.nama_pengguna);
        nik = view.findViewById(R.id.nik_pengguna);
        no_tlp = view.findViewById(R.id.notlp_pengguna);
        email = view.findViewById(R.id.email_pengguna);
        keluar = view.findViewById(R.id.keluar);
        gambar_profile = view.findViewById(R.id.gambar_profile);
        context = view.getContext();
        preferences = new Preferences(context);

    }
}
