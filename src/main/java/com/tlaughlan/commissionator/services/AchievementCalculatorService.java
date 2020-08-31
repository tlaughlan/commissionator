package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.util.CommissionatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AchievementCalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AchievementCalculatorService.class);
    private static final Float achievementCap = 99.98f;

    /***
     * This method calculates the achievement based off the actual and target of a commission. The method checks
     * requisite values for null and fails early if this is the case. The error message in unspecific so as not to leak
     * implementation detail.
     *
     * @param commission
     * @return achievement
     */
    public static Float calculateAchievement(Commission commission) {
        Integer actual = commission.getActual();
        Integer target = commission.getTarget();
        if (actual == null || target == null) {
            throw new IllegalArgumentException("Error occurred during achievement calculation.");
        }

        Float achievement = CommissionatorUtils.roundToTwoDecimals((float) actual/target);
        achievement = adjustForCap(achievement);
        LOGGER.info("Achievement calculated: " + achievement);
        return achievement;
    }

    private static Float adjustForCap(Float achievement) {
        if (achievement > achievementCap) {
            return achievementCap;
        } else {
            return achievement;
        }
    }
}
