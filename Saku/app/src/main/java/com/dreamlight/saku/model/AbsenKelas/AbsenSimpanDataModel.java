package com.dreamlight.saku.model.AbsenKelas;

import java.util.ArrayList;
import java.util.List;

public class AbsenSimpanDataModel {
    private String kode_pp;
    private String kode_lokasi;
    private String kode_kelas;
    private String kode_matpel;
    private String tanggal;
    private Integer stsSimpan;
    private String kode_ta;
    private String nik;
//    private String Details;
    private ArrayList<DetailAbsenModel> DETAIL;

    public String getKode_pp() {
        return kode_pp;
    }

    public void setKode_pp(String kode_pp) {
        this.kode_pp = kode_pp;
    }

    public String getKode_lokasi() {
        return kode_lokasi;
    }

    public void setKode_lokasi(String kode_lokasi) {
        this.kode_lokasi = kode_lokasi;
    }

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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getStsSimpan() {
        return stsSimpan;
    }

    public void setStsSimpan(Integer stsSimpan) {
        this.stsSimpan = stsSimpan;
    }

    public String getKode_ta() {
        return kode_ta;
    }

    public void setKode_ta(String kode_ta) {
        this.kode_ta = kode_ta;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public ArrayList<DetailAbsenModel> getDETAIL() {
        return DETAIL;
    }

    public void setDETAIL(ArrayList<DetailAbsenModel> DETAIL) {
        this.DETAIL = DETAIL;
    }

    public AbsenSimpanDataModel(String kode_pp, String kode_lokasi, String kode_kelas, String kode_matpel, String tanggal, Integer stsSimpan, String kode_ta, String nik, ArrayList<DetailAbsenModel> DETAIL) {
        this.kode_pp = kode_pp;
        this.kode_lokasi = kode_lokasi;
        this.kode_kelas = kode_kelas;
        this.kode_matpel = kode_matpel;
        this.tanggal = tanggal;
        this.stsSimpan = stsSimpan;
        this.kode_ta = kode_ta;
        this.nik = nik;
        this.DETAIL = DETAIL;
//        for (int i=0;i<DETAIL.size();i++){
//            this.Details = this.Details+"{nis: "+DETAIL.get(i).getNis().toString()+", status: "+DETAIL.get(i).getStatus().toString()+" },";
//            if(i == DETAIL.size()){
//                this.Details = this.Details+"{nis: "+DETAIL.get(i).getNis().toString()+", status: "+DETAIL.get(i).getStatus().toString()+" }";
//            }
//        }
    }

    public String toString() {

        return "kode_pp: "+kode_pp+", kode_lokasi: "+kode_lokasi+", kode_kelas: "+kode_kelas+", kode_matpel: "+kode_matpel+", " +
            "tanggal: "+tanggal+", stsSimpan: "+stsSimpan+", kode_ta: "+kode_ta+", nik: "+nik+", Detail: "+DETAIL;
    }

}
