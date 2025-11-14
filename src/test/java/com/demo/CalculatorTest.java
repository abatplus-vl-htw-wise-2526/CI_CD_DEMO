package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test Addition")
    public void testAdd() {
        assertEquals(8, calculator.add(5, 3));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
    }

    @Test
    @DisplayName("Test Subtraktion")
    public void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    @DisplayName("Test Multiplikation")
    public void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(25, calculator.multiply(-5, -5));
    }

    @Test
    @DisplayName("Test Division")
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), 0.001);
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
        assertEquals(-2.0, calculator.divide(10, -5), 0.001);
    }

    @Test
    @DisplayName("Test Division durch Null")
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division durch Null ist nicht erlaubt", exception.getMessage());
    }

    @Test
    @DisplayName("Test Primzahl-Erkennung")
    public void testIsPrime() {
        assertTrue(calculator.isPrime(2));
        assertTrue(calculator.isPrime(17));
        assertTrue(calculator.isPrime(23));
        assertFalse(calculator.isPrime(1));
        assertFalse(calculator.isPrime(4));
        assertFalse(calculator.isPrime(20));
    }
}
