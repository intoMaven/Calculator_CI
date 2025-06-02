package com.example;

import com.example.interfaces.IFlipper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlipperUnitTest {
    private IFlipper flipper;

    @BeforeEach
    public void setUp() {
        flipper = new Flipper();
    }

    @Test
    public void flipperTest() {
        assertEquals(-10, flipper.flip(10));
        assertEquals(7, flipper.flip(-7));
        assertEquals(0, flipper.flip(0));
    }

    @Test
    public void edgeFlipTest() {
        assertEquals(Integer.MIN_VALUE + 1, flipper.flip(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, flipper.flip(Integer.MIN_VALUE + 1));
    }

}
