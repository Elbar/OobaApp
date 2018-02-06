package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class AddAddressDTO {
    @SerializedName("sql")
    @Expose
    private int sql;

    @SerializedName("fio")
    @Expose
    private int fio;

    @SerializedName("address")
    @Expose
    private int address;

    @SerializedName("mobile_phone")
    @Expose
    private int mobile_phone;

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getFio() {
        return fio;
    }

    public void setFio(int fio) {
        this.fio = fio;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(int mobile_phone) {
        this.mobile_phone = mobile_phone;
    }
}
