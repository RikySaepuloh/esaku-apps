package com.dreamlight.saku.model;

import com.google.gson.annotations.SerializedName;

public class PpItemModel {
    @SerializedName("nama")
    private String nama;

    @SerializedName("kode_pp")
    private String kodePp;

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setKodePp(String kodePp){
        this.kodePp = kodePp;
    }

    public String getKodePp(){
        return kodePp;
    }

    @Override
    public String toString(){
        return
                "PpItem{" +
                        "nama = '" + nama + '\'' +
                        ",kode_pp = '" + kodePp + '\'' +
                        "}";
    }
}
