package com.tlaughlan.commissionator.models;

import com.tlaughlan.commissionator.constants.Constants;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class InputDetails {

    @NotNull(message = Constants.nullMessage)
    @Positive(message = Constants.positiveIntegerMessage)
    private Integer actual;

    @NotNull(message = Constants.nullMessage)
    @Min(value = 1, message = Constants.minIntegerMessage)
    private Integer target;

    @NotNull(message = Constants.nullMessage)
    @Min(value = 1, message = Constants.numberRangeMessage)
    @Max(value = 10000, message = Constants.numberRangeMessage)
    private Integer motc;

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
