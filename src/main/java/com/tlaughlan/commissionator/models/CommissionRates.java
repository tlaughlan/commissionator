package com.tlaughlan.commissionator.models;

import java.util.ArrayList;
import java.util.List;

public class CommissionRates {

    private float[][] rateData = {
            {0f, 0.8f, 0f, 0f},
            {0.8f, 1f, 0.8f, 1f},
            {1f, 2f, 1f, 1.5f},
            {2f, 3f, 2.5f, 0.5f},
            {3f, 99.99f, 3f, 0f}
    };
    private List<RateRange> rateRanges;
    private float base;
    private float rate;

    public CommissionRates (float achievement) {
        rateRanges = generateRateRanges(this.rateData);
        determineBaseAndRate(achievement);
    }

    private List<RateRange> generateRateRanges (float[][] rateData) {
        List<RateRange> rateRanges = new ArrayList<>();
        for (int x = 0; x < rateData.length; x++) {
            rateRanges.add(new RateRange(rateData[x][0], rateData[x][1], rateData[x][2], rateData[x][3]));
        }
        return rateRanges;
    }

    private void determineBaseAndRate (float achievement) {
        for (RateRange rateRange : rateRanges) {
            if (rateRange.getAchievementFloor() <= achievement && rateRange.getAchievementCeiling() > achievement) {
                this.base = rateRange.getBase();
                this.rate = rateRange.getRate();
            }
        }
    }
}
