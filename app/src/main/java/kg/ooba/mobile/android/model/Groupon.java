package kg.ooba.mobile.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Groupon{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("goods_name")
    @Expose
    private String goodsName;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("price")
    @Expose
    private String price;
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
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("pic_url")
    @Expose
    private String picUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

}