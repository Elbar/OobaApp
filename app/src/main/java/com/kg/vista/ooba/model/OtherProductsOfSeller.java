package com.kg.vista.ooba.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OtherProductsOfSeller {

    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("total_items")
    @Expose
    private String totalItems;
    @SerializedName("itemlist")
    @Expose
    private List<ItemList> itemlist = null;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public List<ItemList> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<ItemList> itemlist) {
        this.itemlist = itemlist;
    }

}