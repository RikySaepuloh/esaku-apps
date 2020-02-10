package com.dreamlight.saku.model.JadwalSekarang;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListJadwalSekarangModel {
    @SerializedName("daftar")
    private List<JadwalSekarangModel> daftar;
    @SerializedName("status")
    private boolean status;

    public List<JadwalSekarangModel> getDaftar() {
        return daftar;
    }

    public void setDaftar(List<JadwalSekarangModel> daftar) {
        this.daftar = daftar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ListJadwalSekarangModel(List<JadwalSekarangModel> daftar, boolean status) {
        this.daftar = daftar;
        this.status = status;
    }
}
