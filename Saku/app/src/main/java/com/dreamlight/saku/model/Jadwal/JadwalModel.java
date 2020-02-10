package com.dreamlight.saku.model.Jadwal;

public class JadwalModel {
    private String kode_slot;
    private String kode_kelas;
    private String kode_hari;
    private String kode_matpel;
    private String nama_matpel;
    private String nik;
    private String nama_guru;
    private String jam1;
    private String jam2;

    public String getKode_slot() {
        return kode_slot;
    }

    public void setKode_slot(String kode_slot) {
        this.kode_slot = kode_slot;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getKode_hari() {
        return kode_hari;
    }

    public void setKode_hari(String kode_hari) {
        this.kode_hari = kode_hari;
    }

    public String getKode_matpel() {
        return kode_matpel;
    }

    public void setKode_matpel(String kode_matpel) {
        this.kode_matpel = kode_matpel;
    }

    public String getNama_matpel() {
        return nama_matpel;
    }

    public void setNama_matpel(String nama_matpel) {
        this.nama_matpel = nama_matpel;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getJam1() {
        return jam1;
    }

    public void setJam1(String jam1) {
        this.jam1 = jam1;
    }

    public String getJam2() {
        return jam2;
    }

    public void setJam2(String jam2) {
        this.jam2 = jam2;
    }

    public JadwalModel(String kode_slot, String kode_kelas, String kode_hari, String kode_matpel, String nama_matpel, String nik, String nama_guru, String jam1, String jam2) {
        this.kode_slot = kode_slot;
        this.kode_kelas = kode_kelas;
        this.kode_hari = kode_hari;
        this.kode_matpel = kode_matpel;
        this.nama_matpel = nama_matpel;
        this.nik = nik;
        this.nama_guru = nama_guru;
        this.jam1 = jam1;
        this.jam2 = jam2;
    }
}
