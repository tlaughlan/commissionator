package com.tlaughlan.commissionator.pojos;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommissionRatesTests {

    @Test
    public void testGenerateRateRanges() {
        CommissionRates testCommissionRates = new CommissionRates();
        List<RateRange> testRateRanges = testCommissionRates.getRateRanges();
        assertFalse(testRateRanges.isEmpty());
    }
}
