package com.dreamlight.saku;

public class ItemEditAbsenKelas {
    private String img;
    private String nama_siswa;
    private String nis_siswa;
    private String keterangan_siswa;

    public ItemEditAbsenKelas(String img, String nama_siswa, String nis_siswa, String keterangan_siswa) {
        this.img = img;
        this.nama_siswa = nama_siswa;
        this.nis_siswa = nis_siswa;
        this.keterangan_siswa = keterangan_siswa;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getNis_siswa() {
        return nis_siswa;
    }

    public void setNis_siswa(String nis_siswa) {
        this.nis_siswa = nis_siswa;
    }

    public String getKeterangan_siswa() {
        return keterangan_siswa;
    }

    public void setKeterangan_siswa(String keterangan_siswa) {
        this.keterangan_siswa = keterangan_siswa;
    }
}
