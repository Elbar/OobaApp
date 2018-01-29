package com.kg.vista.ooba.model;


import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductConfig {

    @SerializedName("properties")
    @Expose
    private List<Property> properties = null;
    @SerializedName("specification")
    @Expose
    private List<Specification> specification = null;
    @SerializedName("config")
    @Expose
    private Map<String, RandomKey> config;
    @SerializedName("config_count")
    @Expose
    private Integer configCount;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Specification> getSpecification() {
        return specification;
    }

    public void setSpecification(List<Specification> specification) {
        this.specification = specification;
    }

    public Map<String, RandomKey> getConfig() {
        return config;
    }

    public Integer getConfigCount() {
        return configCount;
    }

    public void setConfigCount(Integer configCount) {
        this.configCount = configCount;
    }

}
