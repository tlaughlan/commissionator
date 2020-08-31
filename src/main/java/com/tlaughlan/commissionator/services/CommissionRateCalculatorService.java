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

    public static Float calculateCommissionRate(Commission commission) {
        Float commissionRate = null;
        RateRange rateRange = findRateRange(commission.getAchievement());
        Float base = rateRange.getBase();
        Float rate = rateRange.getRate();

        if (base != null && rate != null) {
            commissionRate = base + ((commission.getAchievement() - rateRange.getAchievementFloor()) * rate);
        }

        commissionRate = CommissionatorUtils.roundToTwoDecimals(commissionRate);
        LOGGER.info("Commission rate calculated: " + commissionRate);
        return commissionRate;
    }

    private static RateRange findRateRange(Float achievement) {
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
