package com.tlaughlan.commissionator.controllers;

import com.tlaughlan.commissionator.models.Commission;
import com.tlaughlan.commissionator.services.CommissionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @GetMapping("/calculator")
    public String showCalc(Commission commission) { return "calculator"; }

    @PostMapping("/calculator")
    public String processCommission(@Valid Commission commission, BindingResult bindingResult)  {

        if (bindingResult.hasErrors()) {
            return "calculator";
        }

        commission = CommissionService.calculateTotalCommission(commission);
        return "calculator";
    }
}
