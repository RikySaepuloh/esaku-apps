package com.dreamlight.saku.model.AbsenKelas;

import java.util.List;

public class AbsenKelasList {
    private List<AbsenKelasModel> daftar;
    private boolean status;

    public List<AbsenKelasModel> getDaftar() {
        return daftar;
    }

    public void setDaftar(List<AbsenKelasModel> daftar) {
        this.daftar = daftar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AbsenKelasList(List<AbsenKelasModel> daftar, boolean status) {
        this.daftar = daftar;
        this.status = status;
    }
}
