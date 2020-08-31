package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CommissionService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommissionService.class);

    public static Commission calculateTotalCommission(Commission commission) {
        if (commission.getAchievement() == null) {
            commission.setAchievement(AchievementCalculatorService.calculateAchievement(commission));
        }

        if (commission.getCommissionRate() == null) {
            commission.setCommissionRate(CommissionRateCalculatorService.calculateCommissionRate(commission));
        }

        if (commission.getTotalCommission() == null) {
            Float totalCommission = commission.getMotc() * commission.getCommissionRate();
            LOGGER.info("Total commission amount calculated: " + totalCommission);
            commission.setTotalCommission(CommissionatorUtils.roundToTwoDecimals(totalCommission));
        }

        return commission;
    }
}
