package com.skillbox.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class FibonacciCalculatorTest {

    FibonacciCalculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new FibonacciCalculator();
    }

    @Test
    @DisplayName("get Fibonacci number with Exception")
    public void givenException_whenGetFibonacciNumber_thenIndexZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.getFibonacciNumber(0));
    }

    @Test
    @DisplayName("get Fibonacci number with index 1")
    public void givenOne_whenGetFibonacciNumber_thenIndexOne() {
        Integer fibonacciNumber = calculator.getFibonacciNumber(1);
        Assertions.assertEquals((Integer) 1, fibonacciNumber);
    }

    @Test
    @DisplayName("get Fibonacci number with index 2")
    public void givenOne_whenGetFibonacciNumber_thenIndexTwo() {
        Integer fibonacciNumber = calculator.getFibonacciNumber(2);
        Assertions.assertEquals((Integer) 1, fibonacciNumber);
    }

    @Test
    @DisplayName("get Fibonacci number with index 10")
    public void givenNumber_whenGetFibonacciNumber_thenIndexTen() {
        Integer fibonacciNumber = calculator.getFibonacciNumber(10);
        Assertions.assertEquals((Integer) 55, fibonacciNumber);
    }
}
