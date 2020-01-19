package com.dreamlight.saku;

public class Item_Jadwal_Sekarang {
    private String nama_kelas;
    private String jam;
    private String matapelajaran;
    private String status;

    public Item_Jadwal_Sekarang(String nama_kelas, String jam, String matapelajaran, String status) {
        this.nama_kelas = nama_kelas;
        this.jam = jam;
        this.matapelajaran = matapelajaran;
        this.status = status;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getMatapelajaran() {
        return matapelajaran;
    }

    public void setMatapelajaran(String matapelajaran) {
        this.matapelajaran = matapelajaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
