package com.example.integrationTest;

import com.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorIntegrationTest {
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private Flipper flipper;

    @BeforeEach
    public void setUp() {
        adder = new Adder();
        flipper = new Flipper();
        subtractor = new Subtractor(adder, flipper);
        multiplier = new Multiplier(adder, flipper);
        divider = new Divider(subtractor, multiplier); // 단순 구현이면 mock 없이도 테스트 가능
    }

    @Test
    public void testFullOperation() {
        // 1. add + multiply
        int result = adder.add(2, 3); // 5
        assertEquals(5, result);
        assertEquals(10, multiplier.multiply(result, 2)); // 5 * 2

        // 2. subtract + divide
        result = subtractor.subtract(10, 4); // 6
        assertEquals(3, divider.divide(result, 2)); // 6 / 2
    }

    @Test
    public void testChainedOperations() {
        // ((3 + 5) - 2) * 2 = 12
        int sum = adder.add(3, 5);
        int diff = subtractor.subtract(sum, 2);
        int product = multiplier.multiply(diff, 2);
        assertEquals(12, product);
    }
}
