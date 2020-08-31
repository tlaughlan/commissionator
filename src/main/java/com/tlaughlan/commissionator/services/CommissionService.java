package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CommissionService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommissionService.class);

    /***
     * This method uses the other services in the application to produce the total commission figure. The method will
     * fail early if requisite inputs are not initialised. Other requisite inputs such as "actual" and "target" are
     * checked for within the appropriate service which handles them directly. The error message in unspecific so as not
     * to leak implementation detail.
     *
     * @param commission
     * @return commission
     */
    public static Commission calculateTotalCommission(Commission commission) {
        Integer motc = commission.getMotc();
        if (motc == null) {
            throw new IllegalArgumentException("Error occurred during total commission calculation.");
        }

        commission.setAchievement(AchievementCalculatorService.calculateAchievement(commission));
        commission.setCommissionRate(CommissionRateCalculatorService.calculateCommissionRate(commission));

        Float totalCommission = motc * commission.getCommissionRate();
        LOGGER.info("Total commission amount calculated: " + totalCommission);
        commission.setTotalCommission(CommissionatorUtils.roundToTwoDecimals(totalCommission));

        return commission;
    }
}
