package com.example;

import com.example.interfaces.IAdder;
import com.example.interfaces.IFlipper;
import com.example.interfaces.ISubtractor;

public class Subtractor implements ISubtractor {
    private IAdder adder;
    private IFlipper filpper;

    public Subtractor(IAdder adder, IFlipper filpper) {
        this.adder = adder;
        this.filpper = filpper;
    }

    public int subtract(int a, int b) {
        return adder.add(a, filpper.flip(b));
    }
}
