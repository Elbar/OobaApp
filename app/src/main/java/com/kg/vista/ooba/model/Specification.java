package com.kg.vista.ooba.model;

/**
 * Created by Begali on 9/5/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Specification {

    @SerializedName("attr_type")
    @Expose
    private Integer attrType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

}
