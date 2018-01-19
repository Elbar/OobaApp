package com.kg.vista.ooba.model.body;

import java.io.Serializable;
import java.util.List;


public class MFListBody implements Serializable{
    private String userId;
    private List<MFBody> mf = null;
    private String addressId;
    private String shippingId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMf(List<MFBody> mf) {
        this.mf = mf;
    }

    public List<MFBody> getMf() { return mf; }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public void addMFBody(MFBody mfBody){
        this.mf.add(mfBody);
    }
}
