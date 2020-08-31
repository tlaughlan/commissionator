package com.tlaughlan.commissionator.util;

public class CommissionatorUtils {

    public static Float roundToTwoDecimals(Float number) {
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        return (float) roundedNumber;
    }
}
