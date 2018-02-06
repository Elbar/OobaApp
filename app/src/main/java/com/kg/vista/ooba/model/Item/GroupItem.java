package com.kg.vista.ooba.model.Item;

import com.kg.vista.ooba.model.dto.GroupOnDTO;

/**
 * Created by aizhan on 9/8/17.
 */

public class GroupItem {

    private String productId;
    private String image;
    private String title;
    private String price;
    private String quantity;
    private String subtotal;
    private String trackId;
    private String status;

    public GroupItem(String productId, String image, String title, String price, String quantity,
                     String subtotal, String trackId, String status) {
        this.productId = productId;
        this.image = image;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.trackId = trackId;
        this.status = status;
    }

    public static GroupItem of(GroupOnDTO item) {
        return new GroupItem(item.getProductId(), item.getImage(), item.getTitle(), item.getPrice(),
                item.getQuantity(), item.getSubtotal(), item.getTrackId(), item.getStatus());
    }

    public String getProductId() {
        return productId;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getStatus() {
        return status;
    }
}
