package com.example.unitTest;

import com.example.Multiplier;
import com.example.interfaces.IAdder;
import com.example.interfaces.IFlipper;
import com.example.interfaces.IMultiplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierUnitTest {
    private IMultiplier multiplier;

    @BeforeEach
    public void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);

        // flip ����: ������ �����, ����� ������
        Mockito.when(flipper.flip(-2)).thenReturn(2);
        Mockito.when(flipper.flip(-3)).thenReturn(3);
        Mockito.when(flipper.flip(6)).thenReturn(-6);
        Mockito.when(flipper.flip(0)).thenReturn(0);

        // ���� ��� ����: multiply(3, 2) ���� ��� ���� �� �� �ʿ�
        Mockito.when(adder.add(0, 3)).thenReturn(3);
        Mockito.when(adder.add(3, 3)).thenReturn(6);

        // multiply(3, -2) �� flip(-2)=2, ���� �� ��, flip(6)=-6
        Mockito.when(adder.add(0, 3)).thenReturn(3);
        Mockito.when(adder.add(3, 3)).thenReturn(6);

        // multiply(-3, -2) �� flip(-3)=3, flip(-2)=2, ���� �� ��
        // �̹� ������ ������

        multiplier = new Multiplier(adder, flipper);
    }

    @Test
    public void multiplierTest1() {
        assertEquals(6, multiplier.multiply(3, 2));
    }

    @Test
    public void multiplierTest2() {
        assertEquals(-6, multiplier.multiply(3, -2));
        assertEquals(6, multiplier.multiply(-3, -2));
    }

    @Test
    public void zeroAndNegativeCases() {
        // 0 ���� ó��
        assertEquals(0, multiplier.multiply(0, 10));
        assertEquals(0, multiplier.multiply(10, 0));
        assertEquals(0, multiplier.multiply(0, 0));
    }
}
