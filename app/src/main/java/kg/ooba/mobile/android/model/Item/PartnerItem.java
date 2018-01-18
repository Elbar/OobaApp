package kg.ooba.mobile.android.model.Item;

import kg.ooba.mobile.android.model.dto.PartnerItemDTO;

/**
 * Created by aizhan on 9/4/17.
 */

public class PartnerItem {

    private String goodsId;
    private String clientId;
    private String seller;
    private String status;
    private String statusText;
    private String picUrl;
    private String quantity;
    private Integer goodsPrice;
    private Double bonusPrice;
    private Integer amount;
    private Double bonusAmount;
    private String promoCode;
    private String url;

    public PartnerItem(String goodsId, String clientId, String seller, String status, String statusText,
                       String picUrl, String quantity, Integer goodsPrice, Double bonusPrice, Integer amount,
                       Double bonusAmount, String promoCode, String url) {
        this.goodsId = goodsId;
        this.clientId = clientId;
        this.seller = seller;
        this.status = status;
        this.statusText = statusText;
        this.picUrl = picUrl;
        this.quantity = quantity;
        this.goodsPrice = goodsPrice;
        this.bonusPrice = bonusPrice;
        this.amount = amount;
        this.bonusAmount = bonusAmount;
        this.promoCode = promoCode;
        this.url = url;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSeller() {
        return seller;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getQuantity() {
        return quantity;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public Double getBonusPrice() {
        return bonusPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public String getUrl() {
        return url;
    }

    public static PartnerItem of(PartnerItemDTO item) {
        return new PartnerItem(item.getGoodsId(), item.getClientId(), item.getSeller(), item.getStatus(),
                item.getStatusText(), item.getPicUrl(), item.getQuantity(), item.getGoodsPrice(),
                item.getBonusPrice(), item.getAmount(), item.getBonusAmount(), item.getPromoCode(),
                item.getUrl());
    }
}
