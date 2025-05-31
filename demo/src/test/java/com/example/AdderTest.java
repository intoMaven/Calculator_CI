package com.example;

import com.example.interfaces.IAdder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdderTest {
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
}
