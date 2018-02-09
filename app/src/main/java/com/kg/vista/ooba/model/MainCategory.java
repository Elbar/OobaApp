package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainCategory {

    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}