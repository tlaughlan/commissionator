package com.tlaughlan.commissionator.services;

import com.tlaughlan.commissionator.models.Commission;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommissionRateCalculatorServiceTests {

    @Mock
    private Commission mockCommission;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateCommissionRateHappyPath() {
        when(mockCommission.getAchievement()).thenReturn(2.1f);
        Float testCommissionRate = CommissionRateCalculatorService.calculateCommissionRate(mockCommission);
        assertEquals(2.55f, testCommissionRate);
    }

    @Test
    public void testCalculateCommissionRateRoundUp() {
        when(mockCommission.getAchievement()).thenReturn(1.777f);
        Float testCommissionRate = CommissionRateCalculatorService.calculateCommissionRate(mockCommission);
        assertEquals(2.17f, testCommissionRate);
    }

    @Test
    public void testCalculateCommissionRateRoundDown() {
        when(mockCommission.getAchievement()).thenReturn(1.222f);
        Float testCommissionRate = CommissionRateCalculatorService.calculateCommissionRate(mockCommission);
        assertEquals(1.33f, testCommissionRate);
    }

    @Test
    public void testCalculateCommissionRateNullValue() {
        when(mockCommission.getAchievement()).thenReturn(null);
        assertThrows(IllegalArgumentException.class,
                () -> CommissionRateCalculatorService.calculateCommissionRate(mockCommission));
    }
}
