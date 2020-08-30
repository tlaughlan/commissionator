package com.tlaughlan.commissionator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommissionatorController {

    @GetMapping("/calculator")
    public String showCalc(InputDetails inputDetails) { return "calculator"; }

    @PostMapping("/calculator")
    public String checkInputDetails(@Valid InputDetails inputDetails, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "calculator";
        }

        return "redirect:/";
    }

}
