package com.madadipouya.telegram.corona.utils;

public class StringUtils {

    private StringUtils() {

    }

    public static String getOrDefaultEmpty(String str) {
        return org.apache.commons.lang3.StringUtils.isBlank(str) ? org.apache.commons.lang3.StringUtils.EMPTY : str;
    }
}
