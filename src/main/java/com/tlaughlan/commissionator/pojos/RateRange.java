package com.tlaughlan.commissionator.pojos;

public class RateRange {

    private float achievementFloor;
    private float achievementCeiling;
    private float base;
    private float rate;

    public RateRange (float achievementFloor, float achievementCeiling, float base, float rate) {
        this.achievementFloor = achievementFloor;
        this.achievementCeiling = achievementCeiling;
        this.base = base;
        this.rate = rate;
    }

    public float getAchievementFloor() {
        return achievementFloor;
    }

    public float getAchievementCeiling() {
        return achievementCeiling;
    }

    public float getBase() {
        return base;
    }

    public float getRate() {
        return rate;
    }
}
