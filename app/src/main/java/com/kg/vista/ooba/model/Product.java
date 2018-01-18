package com.kg.vista.ooba.model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("price_cn")
    @Expose
    private String priceCn;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("index_shop")
    @Expose
    private String indexShop;
    @SerializedName("goods_desc")
    @Expose
    private List<String> goodsDesc = null;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("goods_url")
    @Expose
    private String goodsUrl;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("cat_id")
    @Expose
    private Integer catId;
    @SerializedName("goods_name")
    @Expose
    private String goodsName;
    @SerializedName("goods_img")
    @Expose
    private String goodsImg;
    @SerializedName("goods_number")
    @Expose
    private String goodsNumber;
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
    private String likes;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("percent")
    @Expose
    private Integer percent;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIndexShop() {
        return indexShop;
    }

    public void setIndexShop(String indexShop) {
        this.indexShop = indexShop;
    }

    public List<String> getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(List<String> goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
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

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
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

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}