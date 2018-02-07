package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WhatsNew {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("discountGoodName")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("add_time")
    @Expose
    private String addTime;
    @SerializedName("agotime")
    @Expose
    private String agotime;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("views")
    @Expose
    private String views;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAgotime() {
        return agotime;
    }

    public void setAgotime(String agotime) {
        this.agotime = agotime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

}
