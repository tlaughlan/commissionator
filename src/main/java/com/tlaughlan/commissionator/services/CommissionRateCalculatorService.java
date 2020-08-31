package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.pojos.CommissionRates;
import com.tlaughlan.commissionator.pojos.RateRange;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.springframework.stereotype.Service;

@Service
public class CommissionRateCalculatorService {

    public static Float calculateCommissionRate(Commission commission) {
        Float commissionRate = null;
        RateRange rateRange = findRateRange(commission.getAchievement());
        Float base = rateRange.getBase();
        Float rate = rateRange.getRate();

        if (base != null && rate != null) {
            commissionRate = base + ((commission.getAchievement() - rateRange.getAchievementFloor()) * rate);
        }

        return CommissionatorUtils.roundToTwoDecimals(commissionRate);
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
