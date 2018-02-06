package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Catalog {

    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("link_name")
    @Expose
    private String linkName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("link_url")
    @Expose
    private String linkUrl;
    @SerializedName("index_shop")
    @Expose
    private String indexShop;
    @SerializedName("link_logo")
    @Expose
    private String linkLogo;
    @SerializedName("filter")
    @Expose
    private String filter;
    @SerializedName("like_shop")
    @Expose
    private String likeShop;
    @SerializedName("dislike_shop")
    @Expose
    private String dislikeShop;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("count_comment")
    @Expose
    private Integer countComment;
    @SerializedName("short_desc")
    @Expose
    private String shortDesc;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getIndexShop() {
        return indexShop;
    }

    public void setIndexShop(String indexShop) {
        this.indexShop = indexShop;
    }

    public String getLinkLogo() {
        return linkLogo;
    }

    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getLikeShop() {
        return likeShop;
    }

    public void setLikeShop(String likeShop) {
        this.likeShop = likeShop;
    }

    public String getDislikeShop() {
        return dislikeShop;
    }

    public void setDislikeShop(String dislikeShop) {
        this.dislikeShop = dislikeShop;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCountComment() {
        return countComment;
    }

    public void setCountComment(Integer countComment) {
        this.countComment = countComment;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

}
