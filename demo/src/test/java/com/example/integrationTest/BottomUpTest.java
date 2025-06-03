package com.example.integrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Adder;
import com.example.Divider;
import com.example.Flipper;
import com.example.Multiplier;
import com.example.Subtractor;

public class BottomUpTest {

    private Adder adder;
    private Flipper flipper;

    private Subtractor subtractor;
    private Multiplier multiplier;

    private Divider divider;

    @BeforeEach
    public void setUp() {
        adder = new Adder();
        flipper = new Flipper();
    }

    @Test
    @DisplayName("Adder + Flipper ���� �׽�Ʈ")
    public void testAdderAndFlipperIntegration() {
        assertEquals(5, adder.add(2, 3));
        assertEquals(-3, flipper.flip(3));
        assertEquals(3, flipper.flip(-3));
    }

    @Test
    @DisplayName("Subtractor ���� �׽�Ʈ (Adder, Flipper ����)")
    public void testSubtractorIntegration() {
        subtractor = new Subtractor(adder, flipper);
        assertEquals(2, subtractor.subtract(5, 3));
        assertEquals(-2, subtractor.subtract(3, 5));
    }

    @Test
    @DisplayName("Multiplier ���� �׽�Ʈ (Adder, Flipper ����)")
    public void testMultiplierIntegration() {
        multiplier = new Multiplier(adder, flipper);
        assertEquals(6, multiplier.multiply(3, 2));
        assertEquals(-6, multiplier.multiply(3, -2));
        assertEquals(0, multiplier.multiply(0, 5));
    }

    @Test
    @DisplayName("Divider ���� �׽�Ʈ (Subtractor, Multiplier ����)")
    public void testDividerIntegration() {
        subtractor = new Subtractor(adder, flipper);
        multiplier = new Multiplier(adder, flipper);
        divider = new Divider(subtractor, multiplier);

        assertEquals(3, divider.divide(6, 2)); // ���� ������
        assertEquals(-3, divider.divide(-6, 2)); // ���� ó��
        assertEquals(2, divider.divide(6, 3));
    }
}
