package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import org.springframework.stereotype.Service;

@Service
public class AchievementCalculatorService {

    private static Float achievementCap = 99.98f;

    public static Float calculateAchievement(Commission commission) {
        Float achievement = null;
        Integer actual = commission.getActual();
        Integer target = commission.getTarget();

        if (actual != null && target != null) {
            achievement = roundToTwoDecimals((float) actual/target);
        }

        return adjustForCap(achievement);
    }

    private static Float roundToTwoDecimals(Float number) {
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        return (float) roundedNumber;
    }

    private static Float adjustForCap(Float achievement) {
        if (achievement > achievementCap && achievement != null) {
            return achievementCap;
        } else {
            return achievement;
        }
    }
}
