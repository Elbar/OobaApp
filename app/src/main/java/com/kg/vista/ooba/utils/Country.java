package com.kg.vista.ooba.utils;

/**
 * Created by aizhan on 9/2/17.
 */

public enum Country {
    CHINA("cn", "Китай"), USA("us", "США");

    private final String code;
    private final String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }
}
