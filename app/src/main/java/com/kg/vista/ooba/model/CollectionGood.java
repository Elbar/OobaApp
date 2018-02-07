package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionGood {

@SerializedName("user_id")
@Expose
private String userId;
@SerializedName("user_name")
@Expose
private String userName;
@SerializedName("reg_time")
@Expose
private String regTime;
@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("info")
@Expose
private String info;
@SerializedName("add_time")
@Expose
private String addTime;
@SerializedName("points")
@Expose
private String points;
@SerializedName("views")
@Expose
private String views;
@SerializedName("goods")
@Expose
private String goods;
@SerializedName("feeds")
@Expose
private String feeds;
@SerializedName("url")
@Expose
private String url;
@SerializedName("pic_url")
@Expose
private String picUrl;
@SerializedName("itemlist")
@Expose
private List<ItemList> itemlist = null;

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getRegTime() {
return regTime;
}

public void setRegTime(String regTime) {
this.regTime = regTime;
}

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

public String getInfo() {
return info;
}

public void setInfo(String info) {
this.info = info;
}

public String getAddTime() {
return addTime;
}

public void setAddTime(String addTime) {
this.addTime = addTime;
}

public String getPoints() {
return points;
}

public void setPoints(String points) {
this.points = points;
}

public String getViews() {
return views;
}

public void setViews(String views) {
this.views = views;
}

public String getGoods() {
return goods;
}

public void setGoods(String goods) {
this.goods = goods;
}

public String getFeeds() {
return feeds;
}

public void setFeeds(String feeds) {
this.feeds = feeds;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getPicUrl() {
return picUrl;
}

public void setPicUrl(String picUrl) {
this.picUrl = picUrl;
}

public List<ItemList> getItemlist() {
return itemlist;
}

public void setItemlist(List<ItemList> itemlist) {
this.itemlist = itemlist;
}

}