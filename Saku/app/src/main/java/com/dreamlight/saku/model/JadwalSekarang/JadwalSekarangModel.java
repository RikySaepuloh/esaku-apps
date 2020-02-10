package com.dreamlight.saku.model.JadwalSekarang;

public class JadwalSekarangModel {
    private String kode_kelas;
    private String kode_matpel;
    private String jam1;
    private String jam2;
    private String matpel;
    private String status;

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getKode_matpel() {
        return kode_matpel;
    }

    public void setKode_matpel(String kode_matpel) {
        this.kode_matpel = kode_matpel;
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

    public String getMatpel() {
        return matpel;
    }

    public void setMatpel(String matpel) {
        this.matpel = matpel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JadwalSekarangModel(String kode_kelas, String kode_matpel, String jam1, String jam2, String matpel, String status) {
        this.kode_kelas = kode_kelas;
        this.kode_matpel = kode_matpel;
        this.jam1 = jam1;
        this.jam2 = jam2;
        this.matpel = matpel;
        this.status = status;
    }
}
