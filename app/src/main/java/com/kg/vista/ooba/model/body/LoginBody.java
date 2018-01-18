package com.kg.vista.ooba.model.body;

/**
 * Created by aizhan on 9/2/17.
 */

public class LoginBody {
    private String mail;
    private String pass;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {

        return mail;
    }

    public String getPass() {
        return pass;
    }
}
