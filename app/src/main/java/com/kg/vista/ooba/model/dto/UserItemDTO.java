package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class UserItemDTO {
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("fio")
    @Expose
    private String fio;

    @SerializedName("idcard")
    @Expose
    private String idcard;

    @SerializedName("sex")
    @Expose
    private int sex;

    @SerializedName("birthdate")
    @Expose
    private String birthdate;

    @SerializedName("mobile_phone")
    @Expose
    private String mobile_phone;

    @SerializedName("balance")
    @Expose
    private float balance;

    @SerializedName("bill")
    @Expose
    private String bill;

    @SerializedName("reg_time")
    @Expose
    private String reg_time;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("img")
    @Expose
    private String img;

    @SerializedName("agotime")
    @Expose
    private String agotime;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setAgotime(String agotime) {
        this.agotime = agotime;
    }

    public String getEmail() {

        return email;
    }

    public String getFio() {
        return fio;
    }

    public String getIdcard() {
        return idcard;
    }

    public int getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public float getBalance() {
        return balance;
    }

    public String getBill() {
        return bill;
    }

    public String getReg_time() {
        return reg_time;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getAgotime() {
        return agotime;
    }
}
