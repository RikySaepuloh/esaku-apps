package com.dreamlight.saku.ui.aktivitas_menagajar;

public class ItemListPesan {
    String Judul;
    String Kepada;
    String Tujuan;
    String Tanggal;
    String Jam;
    String isi;

    public ItemListPesan(String judul, String kepada, String tujuan, String tanggal, String jam, String isi) {
        Judul = judul;
        Kepada = kepada;
        Tujuan = tujuan;
        Tanggal = tanggal;
        Jam = jam;
        this.isi = isi;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getKepada() {
        return Kepada;
    }

    public void setKepada(String kepada) {
        Kepada = kepada;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public void setTujuan(String tujuan) {
        Tujuan = tujuan;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
