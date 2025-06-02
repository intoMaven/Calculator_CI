package com.example.unitTest;

import com.example.Adder;
import com.example.interfaces.IAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdderUnitTest {
    private IAdder adder;

    @BeforeEach
    public void setUp() {
        adder = new Adder();
    }

    @Test
    public void adderTest() {
        assertEquals(7, adder.add(3, 4));
        assertEquals(0, adder.add(5, -5));
        assertEquals(-8, adder.add(-3, -5));
    }

    @Test
    public void edgeCaseTest() {
        assertEquals(Integer.MAX_VALUE, adder.add(0, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, adder.add(0, Integer.MIN_VALUE));
        assertEquals(-1, adder.add(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

}
