package com.kg.vista.ooba.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Itemlist {

    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("num_iid")
    @Expose
    private String numIid;
    @SerializedName("pic_url")
    @Expose
    private String picUrl;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("title")
    @Expose
    private String title;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNumIid() {
        return numIid;
    }

    public void setNumIid(String numIid) {
        this.numIid = numIid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}