package com.example.unitTest;

import com.example.Subtractor;
import com.example.interfaces.IAdder;
import com.example.interfaces.ISubtractor;
import com.example.interfaces.IFlipper;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractorUnitTest {
    private ISubtractor subtractor;

    @BeforeEach
    public void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);

        Mockito.when(flipper.flip(5)).thenReturn(-5);
        Mockito.when(flipper.flip(3)).thenReturn(-3);

        Mockito.when(adder.add(3, -5)).thenReturn(-2);
        Mockito.when(adder.add(-3, -5)).thenReturn(-8);
        Mockito.when(adder.add(5, -3)).thenReturn(2);

        subtractor = new Subtractor(adder, flipper);
    }

    @Test
    public void subtractorTest() {
        assertEquals(-2, subtractor.subtract(3, 5));
    }

    @Test
    public void subtractWithNegativeNumbers() {
        assertEquals(-8, subtractor.subtract(-3, 5)); // -3 - 5 = -8
        assertEquals(2, subtractor.subtract(5, 3));
    }

}
