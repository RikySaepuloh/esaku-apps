package com.dreamlight.saku.model.AbsenKelas;

public class AbsenKelasModel {
    private String kode_kelas;
    private String jum_sis;
    private String jum_hadir;
    private String jum_sakit;
    private String jum_izin;
    private String jum_alpa;

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getJum_sis() {
        return jum_sis;
    }

    public void setJum_sis(String jum_sis) {
        this.jum_sis = jum_sis;
    }

    public String getJum_hadir() {
        return jum_hadir;
    }

    public void setJum_hadir(String jum_hadir) {
        this.jum_hadir = jum_hadir;
    }

    public String getJum_sakit() {
        return jum_sakit;
    }

    public void setJum_sakit(String jum_sakit) {
        this.jum_sakit = jum_sakit;
    }

    public String getJum_izin() {
        return jum_izin;
    }

    public void setJum_izin(String jum_izin) {
        this.jum_izin = jum_izin;
    }

    public String getJum_alpa() {
        return jum_alpa;
    }

    public void setJum_alpa(String jum_alpa) {
        this.jum_alpa = jum_alpa;
    }

    public AbsenKelasModel(String kode_kelas, String jum_sis, String jum_hadir, String jum_sakit, String jum_izin, String jum_alpa) {
        this.kode_kelas = kode_kelas;
        this.jum_sis = jum_sis;
        this.jum_hadir = jum_hadir;
        this.jum_sakit = jum_sakit;
        this.jum_izin = jum_izin;
        this.jum_alpa = jum_alpa;
    }
}
