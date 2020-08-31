package com.tlaughlan.commissionator.util;

import org.springframework.stereotype.Component;

@Component
public class CommissionatorUtils {

    /***
     * This simple method rounds the provided float up to the nearest two decimal places. If the provided number is null
     * then an error is logged and null is returned instead.
     *
     * @param number
     * @return roundedNumber
     */
    public static Float roundToTwoDecimals(Float number) {
        if (number == null) {
            return null;
        }
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        return (float) roundedNumber;
    }
}
