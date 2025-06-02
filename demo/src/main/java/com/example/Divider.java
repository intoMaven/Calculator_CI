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
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        // 부호 저장
        boolean negative = (a < 0) ^ (b < 0);

        // 절댓값 사용
        int dividend = Math.abs(a);
        int divisor = Math.abs(b);

        int count = 0;
        int remaining = dividend;

        // 반복적으로 뺄셈 수행
        while (remaining >= divisor) {
            remaining = subtractor.subtract(remaining, divisor);
            count++;
        }

        // 음수 처리
        return negative ? multiplier.multiply(count, -1) : count;
    }
}
