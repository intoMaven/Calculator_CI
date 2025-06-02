package com.example;

import com.example.interfaces.IAdder;
import com.example.interfaces.IFlipper;
import com.example.interfaces.ISubtractor;

public class Subtractor implements ISubtractor {
    private IAdder adder;
    private IFlipper flipper;

    public Subtractor(IAdder adder, IFlipper filpper) {
        this.adder = adder;
        this.flipper = filpper;
    }

    public int subtract(int a, int b) {
        return adder.add(a, flipper.flip(b));
    }
}
