package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import org.springframework.stereotype.Service;


@Service
public class CommissionService {

    public static Commission calculateCommission(Commission commission) {
        if (commission.getAchievement() == null) {
            commission.setAchievement(AchievementCalculatorService.calculateAchievement(commission));
        }

        //Calculate commissionRate and totalCommission.

        return commission;
    }


}
