package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommissionServiceTests {

    private Commission testCommission;

    @BeforeEach
    public void setup() {
        testCommission = null;
    }

    @Test
    public void testCalculateTotalCommissionHappyPath() {
        testCommission = new Commission();
        testCommission.setActual(210);
        testCommission.setTarget(100);
        testCommission.setMotc(5000);
        testCommission = CommissionService.calculateTotalCommission(testCommission);
        assertEquals(12750f, testCommission.getTotalCommission());
    }

    @Test
    public void testCalculateTotalCommissionEdgeOfRange() {
        testCommission = new Commission();
        testCommission.setActual(300);
        testCommission.setTarget(150);
        testCommission.setMotc(5000);
        testCommission = CommissionService.calculateTotalCommission(testCommission);
        assertEquals(12500f, testCommission.getTotalCommission());
    }

    @Test
    public void testCalculateTotalCommissionNullMotc() {
        testCommission = new Commission();
        testCommission.setMotc(null);
        assertThrows(IllegalArgumentException.class,
                () -> CommissionService.calculateTotalCommission(testCommission));
    }
}
