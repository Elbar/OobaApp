package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/6/17.
 */

public class MFListDTO {
    @SerializedName("requisites")
    @Expose
    private String requisites;
    @SerializedName("user_addresses")
    @Expose
    private List<AddressDTO> addressDTO = null;
    @SerializedName("shipping_types")
    @Expose
    private List<ShippingDTO> shippingDTO = null;
    @SerializedName("good_types")
    @Expose
    private List<String> goodTypes = null;

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public List<AddressDTO> getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(List<AddressDTO> addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<ShippingDTO> getShippingDTO() {
        return shippingDTO;
    }

    public void setShippingDTO(List<ShippingDTO> shippingDTO) {
        this.shippingDTO = shippingDTO;
    }

    public List<String> getGoodTypes() {
        return goodTypes;
    }

    public void setGoodTypes(List<String> goodTypes) {
        this.goodTypes = goodTypes;
    }
}
