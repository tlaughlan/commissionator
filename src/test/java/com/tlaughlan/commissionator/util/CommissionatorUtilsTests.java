package com.tlaughlan.commissionator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommissionatorUtilsTests {

    @Test
    public void testRoundToTwoDecimalsRoundUp() {
        Float testNumber = 0.8888f;
        Float roundedTestNumber = CommissionatorUtils.roundToTwoDecimals(testNumber);
        assertEquals(0.89f, roundedTestNumber);
    }

    @Test
    public void testRoundToTwoDecimalsRoundDown() {
        Float testNumber = 0.8833f;
        Float roundedTestNumber = CommissionatorUtils.roundToTwoDecimals(testNumber);
        assertEquals(0.88f, roundedTestNumber);
    }

    @Test
    public void testRoundToTwoDecimalsNullNumber() {
        assertNull(CommissionatorUtils.roundToTwoDecimals(null));
    }
}
