package com.dreamlight.saku.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class kodePPModel {
    @SerializedName("pp")
    private List<PpItemModel> pp;

    public void setPp(List<PpItemModel> pp){
        this.pp = pp;
    }

    public List<PpItemModel> getPp(){
        return pp;
    }

    @Override
    public String toString(){
        return
                "KodePpPresenter{" +
                        "pp = '" + pp + '\'' +
                        "}";
    }
}
