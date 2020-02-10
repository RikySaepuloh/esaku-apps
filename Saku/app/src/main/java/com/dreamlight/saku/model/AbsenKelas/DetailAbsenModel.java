package com.dreamlight.saku.model.AbsenKelas;

public class DetailAbsenModel {
    private String nis;
    private String status;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DetailAbsenModel(String nis, String status) {
        this.nis = nis;
        this.status = status;
    }
}
