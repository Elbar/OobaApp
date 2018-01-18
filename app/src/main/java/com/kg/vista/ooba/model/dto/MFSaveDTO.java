package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/7/17.
 */

public class MFSaveDTO {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("shipping_name")
    @Expose
    private String shippingName;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }
}
