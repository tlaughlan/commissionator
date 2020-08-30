package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import org.springframework.stereotype.Service;

@Service
public class AchievementCalculatorService {

    public static Float calculateAchievement(Commission commission) {
        Float achievement = null;
        Integer actual = commission.getActual();
        Integer target = commission.getTarget();

        if (actual != null && target != null) {
            achievement = roundToTwoDecimals((float) actual/target);
        }

        return achievement;
    }

    private static Float roundToTwoDecimals(Float number) {
        double roundedNumber = Math.round(number * 100.0) / 100.0;
        return (float) roundedNumber;
    }
}
