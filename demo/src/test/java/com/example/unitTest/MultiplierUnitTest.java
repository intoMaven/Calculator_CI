package com.example.unitTest;

import com.example.Multiplier;
import com.example.interfaces.IAdder;
import com.example.interfaces.IFlipper;
import com.example.interfaces.IMultiplier;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplierUnitTest {
    private IMultiplier multiplier;

    @BeforeEach
    public void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);

        Mockito.when(flipper.flip(-2)).thenReturn(2);
        Mockito.when(flipper.flip(3)).thenReturn(-3);
        Mockito.when(adder.add(0, 3)).thenReturn(3);
        Mockito.when(adder.add(3, 3)).thenReturn(6);
        Mockito.when(adder.add(0, -3)).thenReturn(-3);
        Mockito.when(adder.add(-3, -3)).thenReturn(-6);
        multiplier = new Multiplier(adder, flipper);
    }

    @Test
    public void multiplierTest1() {
        assertEquals(6, multiplier.multiply(3, 2));
    }

    @Test
    public void multiplierTest2() {
        assertEquals(-6, multiplier.multiply(3, -2));
    }

    @Test
    public void zeroAndNegativeCases() {
        assertEquals(0, multiplier.multiply(0, 10));
        assertEquals(0, multiplier.multiply(10, 0));
        assertEquals(0, multiplier.multiply(0, 0));
    }

}
