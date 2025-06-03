package com.example.integrationTest;

import com.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        divider = new Divider(subtractor, multiplier); // �ܼ� �����̸� mock ���̵� �׽�Ʈ ����
    }

    @Test
    @DisplayName("���� ���� ���� �׽�Ʈ: ��ȣ ���� ����")
    public void testNegativeOperations() {
        assertEquals(-2, subtractor.subtract(3, 5));
        assertEquals(-6, multiplier.multiply(-2, 3));
        assertEquals(2, divider.divide(-6, -3));
    }

    @Test
    @DisplayName("��谪 �׽�Ʈ: 0�� 1�� ���� ����")
    public void testZeroAndOne() {
        assertEquals(0, multiplier.multiply(0, 100));
        assertEquals(100, multiplier.multiply(1, 100));
        assertEquals(0, subtractor.subtract(0, 0));
        assertEquals(1, divider.divide(100, 100));
    }

    @Test
    @DisplayName("add �� multiply, subtract �� divide ���� �ó�����")
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
    @DisplayName("���� ���� �帧 �׽�Ʈ: ((3 + 5) - 2) * 2 = 12")
    public void testChainedOperations() {
        // ((3 + 5) - 2) * 2 = 12
        int sum = adder.add(3, 5);
        int diff = subtractor.subtract(sum, 2);
        int product = multiplier.multiply(diff, 2);
        assertEquals(12, product);
    }
}
