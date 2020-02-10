package com.dreamlight.saku.model.DaftarSiswa;

import com.google.gson.annotations.SerializedName;

public class DaftarSiswaModel {
    private String nis;
    private String nama;
    private String sts;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public DaftarSiswaModel(String nis, String nama, String sts) {
        this.nis = nis;
        this.nama = nama;
        this.sts = sts;
    }
}
