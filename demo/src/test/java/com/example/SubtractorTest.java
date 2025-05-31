package com.example;

import com.example.interfaces.IAdder;
import com.example.interfaces.ISubtractor;
import com.example.interfaces.IFlipper;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractorTest {
    private ISubtractor subtractor;

    @BeforeEach
    public void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);

        Mockito.when(flipper.flip(5)).thenReturn(-5);
        Mockito.when(adder.add(3, -5)).thenReturn(-2);
        subtractor = new Subtractor(adder, flipper);
    }

    @Test
    public void subtractorTest() {
        assertEquals(-2, subtractor.subtract(3, 5));
    }
}
