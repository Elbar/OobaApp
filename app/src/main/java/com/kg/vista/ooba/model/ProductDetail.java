package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetail {

    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("price_cn")
    @Expose
    private String priceCn;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("index_shop")
    @Expose
    private String indexShop;
    @SerializedName("shop_index")
    @Expose
    private String shopIndex;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("goods_desc")
    @Expose
    private List<Object> goodsDesc = null;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("referal_id")
    @Expose
    private Integer referalId;
    @SerializedName("goods_url")
    @Expose
    private String goodsUrl;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("cat_id")
    @Expose
    private Integer catId;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("goods_name")
    @Expose
    private String goodsName;
    @SerializedName("goods_img")
    @Expose
    private String goodsImg;
    @SerializedName("goods_number")
    @Expose
    private Integer goodsNumber;
    @SerializedName("detail_url_title")
    @Expose
    private String detailUrlTitle;
    @SerializedName("detail_url")
    @Expose
    private String detailUrl;
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("warranty")
    @Expose
    private String warranty;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("geo")
    @Expose
    private String geo;
    @SerializedName("likes")
    @Expose
    private Integer likes;

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getPriceCn() {
        return priceCn;
    }

    public void setPriceCn(String priceCn) {
        this.priceCn = priceCn;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIndexShop() {
        return indexShop;
    }

    public void setIndexShop(String indexShop) {
        this.indexShop = indexShop;
    }

    public String getShopIndex() {
        return shopIndex;
    }

    public void setShopIndex(String shopIndex) {
        this.shopIndex = shopIndex;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Object> getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(List<Object> goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Integer getReferalId() {
        return referalId;
    }

    public void setReferalId(Integer referalId) {
        this.referalId = referalId;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getDetailUrlTitle() {
        return detailUrlTitle;
    }

    public void setDetailUrlTitle(String detailUrlTitle) {
        this.detailUrlTitle = detailUrlTitle;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

}