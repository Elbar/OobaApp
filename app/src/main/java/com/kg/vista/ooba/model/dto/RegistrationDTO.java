package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class RegistrationDTO {
    @SerializedName("login")
    @Expose
    private int login;

    @SerializedName("password")
    @Expose
    private int password;

    public int getLogin() {

        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
