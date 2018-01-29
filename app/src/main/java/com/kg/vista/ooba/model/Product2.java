package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product2 {

    @SerializedName("images")
    @Expose
    private String images;
    @SerializedName("pics")
    @Expose
    private List<String> pics = null;
    @SerializedName("url_product")
    @Expose
    private String urlProduct;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("nick_url")
    @Expose
    private String nickUrl;
    @SerializedName("nick_img")
    @Expose
    private String nickImg;
    @SerializedName("nick_title")
    @Expose
    private String nickTitle;
    @SerializedName("view")
    @Expose
    private Integer view;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("old_price")
    @Expose
    private Integer oldPrice;
    @SerializedName("agotime")
    @Expose
    private String agotime;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getUrlProduct() {
        return urlProduct;
    }

    public void setUrlProduct(String urlProduct) {
        this.urlProduct = urlProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNickUrl() {
        return nickUrl;
    }

    public void setNickUrl(String nickUrl) {
        this.nickUrl = nickUrl;
    }

    public String getNickImg() {
        return nickImg;
    }

    public void setNickImg(String nickImg) {
        this.nickImg = nickImg;
    }

    public String getNickTitle() {
        return nickTitle;
    }

    public void setNickTitle(String nickTitle) {
        this.nickTitle = nickTitle;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getAgotime() {
        return agotime;
    }

    public void setAgotime(String agotime) {
        this.agotime = agotime;
    }

}