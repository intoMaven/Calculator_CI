package com.example;

import com.example.interfaces.IDivider;
import com.example.interfaces.ISubtractor;
import com.example.interfaces.IMultiplier;

public class Divider implements IDivider {

    private ISubtractor subtractor;
    private IMultiplier multiplier;

    public Divider(ISubtractor subtractor, IMultiplier multiplier) {
        this.subtractor = subtractor;
        this.multiplier = multiplier;
    }

    @Override
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("0���� ���� �� �����ϴ�.");
        }

        // ��ȣ ����
        boolean negative = (a < 0) ^ (b < 0);

        // ���� ���
        int dividend = Math.abs(a);
        int divisor = Math.abs(b);

        int count = 0;
        int remaining = dividend;

        // �ݺ������� ���� ����
        while (remaining >= divisor) {
            remaining = subtractor.subtract(remaining, divisor);
            count++;
        }

        // ���� ó��
        return negative ? multiplier.multiply(count, -1) : count;
    }
}
