package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {

    @SerializedName("product")
    @Expose
    private List<Product2> product = null;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_index")
    @Expose
    private String categoryIndex;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop")
    @Expose
    private Shop shop;

    public List<Product2> getProduct() {
        return product;
    }

    public void setProduct(List<Product2> product) {
        this.product = product;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(String categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}