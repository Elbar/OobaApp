package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/4/17.
 */

public class PartnerItemDTO {
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("pic_url")
    @Expose
    private String picUrl;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("goods_price")
    @Expose
    private Integer goodsPrice;
    @SerializedName("bonus_price")
    @Expose
    private Double bonusPrice;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("bonus_amount")
    @Expose
    private Double bonusAmount;
    @SerializedName("promo_code")
    @Expose
    private String promoCode;
    @SerializedName("url")
    @Expose
    private String url;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getBonusPrice() {
        return bonusPrice;
    }

    public void setBonusPrice(Double bonusPrice) {
        this.bonusPrice = bonusPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
