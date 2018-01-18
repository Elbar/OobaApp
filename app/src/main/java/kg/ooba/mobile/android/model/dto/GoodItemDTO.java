package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/5/17.
 */

public class GoodItemDTO {
    @SerializedName("total")
    @Expose
    private double total;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("rec_id")
    @Expose
    private String recId;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("attr")
    @Expose
    private String attr;
    @SerializedName("pic_url")
    @Expose
    private String picUrl;
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("comments")
    @Expose
    private String comments;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
