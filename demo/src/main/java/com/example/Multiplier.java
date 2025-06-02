package com.example;

import com.example.interfaces.IAdder;
import com.example.interfaces.IFlipper;
import com.example.interfaces.IMultiplier;

public class Multiplier implements IMultiplier {
    private IAdder adder;
    private IFlipper flipper;

    public Multiplier(IAdder adder, IFlipper flipper) {
        this.adder = adder;
        this.flipper = flipper;
    }

    public int multiply(int a, int b) {
        boolean negativeResult = false;

        // ���� ��ȣ ó��
        if (a < 0) {
            a = flipper.flip(a); // ���� -> ����� ��ȯ
            negativeResult = !negativeResult;
        }
        if (b < 0) {
            b = flipper.flip(b); // ���� -> ����� ��ȯ
            negativeResult = !negativeResult;
        }

        int result = 0;
        for (int i = 0; i < b; i++) {
            result = adder.add(result, a);
        }

        // ��� ��ȣ ó��
        if (negativeResult) {
            result = flipper.flip(result);
        }
        return result;
    }
}
