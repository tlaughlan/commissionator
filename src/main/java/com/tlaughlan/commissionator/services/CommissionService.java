package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.springframework.stereotype.Service;


@Service
public class CommissionService {

    public static Commission calculateTotalCommission(Commission commission) {
        if (commission.getAchievement() == null) {
            commission.setAchievement(AchievementCalculatorService.calculateAchievement(commission));
        }

        if (commission.getCommissionRate() == null) {
            commission.setCommissionRate(CommissionRateCalculatorService.calculateCommissionRate(commission));
        }

        if (commission.getTotalCommission() == null) {
            Float totalCommission = commission.getMotc() * commission.getCommissionRate();
            commission.setTotalCommission(CommissionatorUtils.roundToTwoDecimals(totalCommission));
        }

        return commission;
    }
}
