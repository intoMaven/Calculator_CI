package com.example.unitTest;

import com.example.Divider;
import com.example.interfaces.IDivider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DividerUnitTest {
    private IDivider divider;

    @BeforeEach
    public void setUp() {
        divider = new Divider();
    }

    @Test
    public void dividerTest() {
        assertEquals(2, divider.divide(10, 5));
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

}
