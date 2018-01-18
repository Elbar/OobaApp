package com.kg.vista.ooba.model.Item;

import com.kg.vista.ooba.model.dto.ShippingDTO;

/**
 * Created by aizhan on 9/5/17.
 */

public class ShippingItem {

    private String shippingId;
    private String shippingName;
    private String shippingDesc;

    public ShippingItem(String shippingId, String shippingName, String shippingDesc) {
        this.shippingId = shippingId;
        this.shippingName = shippingName;
        this.shippingDesc = shippingDesc;
    }

    public String getShippingId() {
        return shippingId;
    }

    public String getShippingName() {
        return shippingName;
    }

    public String getShippingDesc() {
        return shippingDesc;
    }

    public static ShippingItem of(ShippingDTO item) {
        return new ShippingItem(item.getShippingId(), item.getShippingName(), item.getShippingDesc());
    }
}
