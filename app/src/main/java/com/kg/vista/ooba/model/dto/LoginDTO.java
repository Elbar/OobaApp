package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class LoginDTO {
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
