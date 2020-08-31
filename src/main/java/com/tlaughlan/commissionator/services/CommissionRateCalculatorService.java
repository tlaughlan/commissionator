package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.pojos.CommissionRates;
import com.tlaughlan.commissionator.pojos.RateRange;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommissionRateCalculatorService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommissionRateCalculatorService.class);
    public static final String COMMISSION_RATE_GENERAL_ERROR = "Error encountered during commission rate calculation.";

    /***
     * This method calculates the commission rate based off the achievement and rate range. The method checks requisite
     * values for null and fails early if this is the case. The error message in unspecific so as not to leak
     * implementation detail.
     *
     * @param commission
     * @return commissionRate
     */
    public static Float calculateCommissionRate(Commission commission) {
        Float achievement = commission.getAchievement();
        RateRange rateRange = findRateRange(achievement);
        if (rateRange == null) {
            throw new IllegalArgumentException (COMMISSION_RATE_GENERAL_ERROR);
        }

        Float commissionRate = rateRange.getBase() + ((achievement - rateRange.getAchievementFloor())
                * rateRange.getRate());
        commissionRate = CommissionatorUtils.roundToTwoDecimals(commissionRate);
        LOGGER.info("Commission rate calculated: " + commissionRate);
        return commissionRate;
    }

    private static RateRange findRateRange(Float achievement) {
        if (achievement == null) {
            throw new IllegalArgumentException(COMMISSION_RATE_GENERAL_ERROR);
        }
        RateRange rateRange = null;
        CommissionRates commissionRates = new CommissionRates();

        for (RateRange currentRateRange : commissionRates.getRateRanges()) {
            if (currentRateRange.getAchievementFloor() <= achievement &&
                    currentRateRange.getAchievementCeiling() > achievement) {
                rateRange = currentRateRange;
            }
        }

        return rateRange;
    }


}
