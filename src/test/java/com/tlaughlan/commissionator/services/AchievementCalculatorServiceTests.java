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
public class AchievementCalculatorServiceTests {

    @Mock
    private Commission mockCommission;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateAchievementHappyPath() {
        when(mockCommission.getActual()).thenReturn(1);
        when(mockCommission.getTarget()).thenReturn(2);
        Float testAchievement = AchievementCalculatorService.calculateAchievement(mockCommission);
        assertEquals(0.5f, testAchievement);
    }

    @Test
    public void testCalculateAchievementRoundedUp() {
        when(mockCommission.getActual()).thenReturn(666);
        when(mockCommission.getTarget()).thenReturn(1000);
        Float testAchievement = AchievementCalculatorService.calculateAchievement(mockCommission);
        assertEquals(0.67f, testAchievement);
    }

    @Test
    public void testCalculateAchievementRoundedDown() {
        when(mockCommission.getActual()).thenReturn(333);
        when(mockCommission.getTarget()).thenReturn(1000);
        Float testAchievement = AchievementCalculatorService.calculateAchievement(mockCommission);
        assertEquals(0.33f, testAchievement);
    }

    @Test
    public void testCalculateAchievementCapped() {
        when(mockCommission.getActual()).thenReturn(100);
        when(mockCommission.getTarget()).thenReturn(1);
        Float testAchievement = AchievementCalculatorService.calculateAchievement(mockCommission);
        assertEquals(99.98f, testAchievement);
    }

    @Test
    public void testCalculateAchievementNullValue() {
        when(mockCommission.getActual()).thenReturn(null);
        when(mockCommission.getTarget()).thenReturn(null);
        assertThrows(IllegalArgumentException.class,
                () -> AchievementCalculatorService.calculateAchievement(mockCommission));
    }
}
