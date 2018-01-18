package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/4/17.
 */

public class PartnerListDTO {
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("seller_products")
    @Expose
    private List<PartnerItemDTO> list = null;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public List<PartnerItemDTO> getList() {
        return list;
    }

    public void setList(List<PartnerItemDTO> list) {
        this.list = list;
    }
}
