package com.madadipouya.telegram.corona.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {

    private NumberUtils() {

    }

    public static String formatThreeDecimal(int number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }
}
