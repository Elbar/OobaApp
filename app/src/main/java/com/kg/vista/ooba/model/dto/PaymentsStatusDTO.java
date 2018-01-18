package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/7/17.
 */

public class PaymentsStatusDTO {
    @SerializedName("paid")
    @Expose
    private Integer paid;
    @SerializedName("unpaid")
    @Expose
    private Integer unpaid;
    @SerializedName("balance")
    @Expose
    private Integer balance;

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(Integer unpaid) {
        this.unpaid = unpaid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
