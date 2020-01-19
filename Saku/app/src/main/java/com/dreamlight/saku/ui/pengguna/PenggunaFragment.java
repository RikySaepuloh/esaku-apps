package com.dreamlight.saku.ui.pengguna;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dreamlight.saku.EditProfile;
import com.dreamlight.saku.R;

public class PenggunaFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengguna,container,false);
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
        return view;

    }
}
