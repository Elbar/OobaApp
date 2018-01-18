package com.kg.vista.ooba.model.Item;

import com.kg.vista.ooba.model.dto.AddressDTO;

/**
 * Created by aizhan on 9/2/17.
 */

public class AddressItem {
    private String name;
    private String address;
    private String phone;
    private String address_id;

    AddressItem(String name, String address, String phone, String address_id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress_id() {
        return address_id;
    }

    public static AddressItem of(AddressDTO item) {
        return new AddressItem(item.getConsignee(), item.getAddress(), item.getTel(), item.getAddress_id());
    }
}
