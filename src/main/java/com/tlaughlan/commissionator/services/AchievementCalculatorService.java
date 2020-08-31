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

    public static Float calculateAchievement(Commission commission) {
        Float achievement = null;
        Integer actual = commission.getActual();
        Integer target = commission.getTarget();

        if (actual != null && target != null) {
            achievement = CommissionatorUtils.roundToTwoDecimals((float) actual/target);
        }

        achievement = adjustForCap(achievement);
        LOGGER.info("Achievement calculated: " + achievement);
        return achievement;
    }

    private static Float adjustForCap(Float achievement) {
        if (achievement > achievementCap && achievement != null) {
            return achievementCap;
        } else {
            return achievement;
        }
    }
}
