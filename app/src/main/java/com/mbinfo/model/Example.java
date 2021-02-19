package com.mbinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("Bannercard_data")
    @Expose
    private List<BannercardDatum> bannercardData = null;

    public List<BannercardDatum> getBannercardData() {
        return bannercardData;
    }

    public void setBannercardData(List<BannercardDatum> bannercardData) {
        this.bannercardData = bannercardData;
    }
}
