package com.example;

import com.example.interfaces.IDivider;

public class Divider implements IDivider {
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("0���� ���� �� �����ϴ�.");
        }
        return a / b;
    }

}
