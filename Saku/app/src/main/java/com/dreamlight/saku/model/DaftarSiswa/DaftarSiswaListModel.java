package com.dreamlight.saku.model.DaftarSiswa;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DaftarSiswaListModel {
    @SerializedName("daftar")
    private List<DaftarSiswaModel> daftar;

    public DaftarSiswaListModel(List<DaftarSiswaModel> daftar, boolean status) {
        this.daftar = daftar;
        this.status = status;
    }

    public List<DaftarSiswaModel> getDaftar() {
        return daftar;
    }

    public void setDaftar(List<DaftarSiswaModel> daftar) {
        this.daftar = daftar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @SerializedName("status")
    private boolean status;
}
