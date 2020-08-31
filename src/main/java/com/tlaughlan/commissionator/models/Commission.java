package com.tlaughlan.commissionator.models;

import com.tlaughlan.commissionator.constants.Constants;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Commission {

    @NotNull(message = Constants.NULL_MESSAGE)
    @Positive(message = Constants.POSITIVE_INTEGER_MESSAGE)
    private Integer actual;

    @NotNull(message = Constants.NULL_MESSAGE)
    @Min(value = 1, message = Constants.MIN_INTEGER_MESSAGE)
    private Integer target;

    @NotNull(message = Constants.NULL_MESSAGE)
    @Min(value = 1, message = Constants.NUMBER_RANGE_MESSAGE)
    @Max(value = 10000, message = Constants.NUMBER_RANGE_MESSAGE)
    private Integer motc;

    private Float achievement;

    private Float commissionRate;

    private Float totalCommission;

    public Float getAchievement() {
        return achievement;
    }

    public void setAchievement(Float achievement) {
        this.achievement = achievement;
    }

    public Float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Float getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Float totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getMotc() {
        return motc;
    }

    public void setMotc(Integer motc) {
        this.motc = motc;
    }
}
