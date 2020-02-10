package com.dreamlight.saku.model.Jadwal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JadwalListModel {
    @SerializedName("daftar")
    private List<JadwalModel> daftar;
    @SerializedName("status")
    private boolean status;

    public List<JadwalModel> getDaftar() {
        return daftar;
    }

    public void setDaftar(List<JadwalModel> daftar) {
        this.daftar = daftar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public JadwalListModel(List<JadwalModel> daftar, boolean status) {
        this.daftar = daftar;
        this.status = status;
    }
}
