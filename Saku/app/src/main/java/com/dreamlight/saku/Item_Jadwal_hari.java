package com.dreamlight.saku;

public class Item_Jadwal_hari {
    private String nama_kelas;
    private String matapelajaran;
    private String jammulai;
    private String jamsampai;

    public Item_Jadwal_hari(String nama_kelas, String matapelajaran, String jammulai, String jamsampai) {
        this.nama_kelas = nama_kelas;
        this.matapelajaran = matapelajaran;
        this.jammulai = jammulai;
        this.jamsampai = jamsampai;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getMatapelajaran() {
        return matapelajaran;
    }

    public void setMatapelajaran(String matapelajaran) {
        this.matapelajaran = matapelajaran;
    }

    public String getJammulai() {
        return jammulai;
    }

    public void setJammulai(String jammulai) {
        this.jammulai = jammulai;
    }

    public String getJamsampai() {
        return jamsampai;
    }

    public void setJamsampai(String jamsampai) {
        this.jamsampai = jamsampai;
    }
}
