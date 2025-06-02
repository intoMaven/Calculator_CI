package com.example.unitTest;

import com.example.Divider;
import com.example.interfaces.IDivider;
import com.example.interfaces.ISubtractor;
import com.example.interfaces.IMultiplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class DividerUnitTest {
    private IDivider divider;

    @BeforeEach
    public void setUp() {
        ISubtractor subtractor = Mockito.mock(ISubtractor.class);
        IMultiplier multiplier = Mockito.mock(IMultiplier.class);

        // 10 / 5 = 2 (두 번 뺌: 10 -> 5 -> 0)
        Mockito.when(subtractor.subtract(10, 5)).thenReturn(5);
        Mockito.when(subtractor.subtract(5, 5)).thenReturn(0);
        // -10 / 5 = -2 → count * -1
        Mockito.when(multiplier.multiply(2, -1)).thenReturn(-2);
        // 10 / -5 = -2
        Mockito.when(multiplier.multiply(2, -1)).thenReturn(-2);
        // -10 / -5 = 2 (양수 유지)
        Mockito.when(multiplier.multiply(2, -1)).thenReturn(-2); // 동일하게 처리 가능

        divider = new Divider(subtractor, multiplier);
    }

    @Test
    public void dividerTest_PositiveCase() {
        assertEquals(2, divider.divide(10, 5));
    }

    @Test
    public void zeroDividendTest() {
        assertEquals(0, divider.divide(0, 3));
    }

    @Test
    public void divideByZeroShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> divider.divide(10, 0));
    }

    @Test
    public void negativeDivisionTest() {
        assertEquals(-2, divider.divide(-10, 5));
        assertEquals(-2, divider.divide(10, -5));
        assertEquals(2, divider.divide(-10, -5));
    }

    @Test
    public void zeroDivisionTest() {
        assertEquals(0, divider.divide(0, 1));
        assertEquals(0, divider.divide(0, -1));
    }
}
