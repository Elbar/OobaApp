package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class UserListDTO {
    @SerializedName("user")
    @Expose
    private UserItemDTO user;

    public UserItemDTO getUser(){return user;}

    public void setUser(UserItemDTO user) {
        this.user = user;
    }
}
