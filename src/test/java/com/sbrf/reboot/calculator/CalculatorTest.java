package com.sbrf.reboot.calculator;

import com.sbrf.reboot.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20.0, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3.0, Calculator.getDivision(9, 3));
    }

    @Test
    void getPower() {
        assertEquals(8.0, Calculator.getPower(2, 3));
    }

    @Test
    void getMin() {
        assertEquals(3.5, Calculator.getMin(3.5,5));
    }

    @Test
    void getMax() {
        assertEquals(5.0, Calculator.getMax(3.5,5));
    }

    @Test
    void classHasSevenMethods(){
       assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }
}
