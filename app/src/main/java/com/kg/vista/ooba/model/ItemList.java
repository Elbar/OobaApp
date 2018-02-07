package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

@SerializedName("goods_id")
@Expose
private String goodsId;
@SerializedName("referal_id")
@Expose
private String referalId;
@SerializedName("pic_url")
@Expose
private String picUrl;

public String getGoodsId() {
return goodsId;
}

public void setGoodsId(String goodsId) {
this.goodsId = goodsId;
}

public String getReferalId() {
return referalId;
}

public void setReferalId(String referalId) {
this.referalId = referalId;
}

public String getPicUrl() {
return picUrl;
}

public void setPicUrl(String picUrl) {
this.picUrl = picUrl;
}

}