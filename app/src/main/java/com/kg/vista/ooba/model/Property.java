package com.kg.vista.ooba.model;

/**
 * Created by Begali on 9/5/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("child")
    @Expose
    private List<String> child = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getChild() {
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }

}
