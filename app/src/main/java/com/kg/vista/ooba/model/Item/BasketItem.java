package com.kg.vista.ooba.model.Item;

import com.kg.vista.ooba.model.dto.GoodItemDTO;

/**
 * Created by aizhan on 9/5/17.
 */

public class BasketItem {

    private double total;
    private String goodsId;
    private String recId;
    private String price;
    private String count;
    private String attr;
    private String picUrl;
    private String seller;
    private String comments;

    public BasketItem(double total, String goodsId, String recId, String price, String count, String attr,
                      String picUrl, String seller, String comments) {
        this.total = total;
        this.goodsId = goodsId;
        this.recId = recId;
        this.price = price;
        this.count = count;
        this.attr = attr;
        this.picUrl = picUrl;
        this.seller = seller;
        this.comments = comments;
    }

    public static BasketItem of(GoodItemDTO item) {
        return new BasketItem(item.getTotal(), item.getGoodsId(), item.getRecId(), item.getPrice(),
                item.getCount(), item.getAttr(), item.getPicUrl(), item.getSeller(), item.getComments());
    }

    public double getTotal() {
        return total;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public String getRecId() {
        return recId;
    }

    public String getPrice() {
        return price;
    }

    public String getCount() {
        return count;
    }

    public String getAttr() {
        return attr;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getSeller() {
        return seller;
    }

    public String getComments() {
        return comments;
    }

    public int decrease(String count) {
        int a = Integer.parseInt(count);
        if (a == 1) {
            return 1;
        } else {
            a -= 1;
            return a;
        }
    }

    public int increase(String count) {
        int a = Integer.parseInt(count);
        a += 1;
        return a;
    }

    public double multiply(String count, String price) {
        double result = 0;
        int a = Integer.parseInt(count);
        double b = Double.parseDouble(price);
        result = a * b;
        return result;
    }
}
