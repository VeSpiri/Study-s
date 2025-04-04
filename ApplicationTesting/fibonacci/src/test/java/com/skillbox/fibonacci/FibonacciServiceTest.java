package com.skillbox.fibonacci;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

    @Mock
    private FibonacciRepository repository;

    @Mock
    private FibonacciCalculator calculator;
    private FibonacciService service;

    @BeforeEach
    public void setUp() {
        service = new FibonacciService(repository, calculator);
    }

    @Test
    @DisplayName("exception then index < 0")
    public void giveException_whenFibonacciNumber_thenIndexNegative() {
        assertThrows( IllegalArgumentException.class,
                () -> service.fibonacciNumber(-1)
        );
    }

    @Test
    @DisplayName("get number from database")
    public void giveDbNumber_whenFibonacciNumber_thenIndexIsPresentInDB() {
        int index = 1;
        FibonacciNumber number = new FibonacciNumber(1, 1);
        when(repository.findByIndex(index)).thenReturn(Optional.of(number));
        FibonacciNumber resultNumber = service.fibonacciNumber(index);
        assertEquals(resultNumber, number);

        verify(repository, times(1)).findByIndex(index);
        verify(calculator, times(0)).getFibonacciNumber(index);
        verify(repository, times(0)).save(resultNumber);
    }

    @Test
    @DisplayName("calculate, add in database and give number")
    public void giveNewNumber_whenFibonacciNumber_thenIndexNotPresentInDB() {
        int index = 10;
        FibonacciNumber number = new FibonacciNumber(10, 55);
        when(calculator.getFibonacciNumber(index)).thenReturn(55);
        when(repository.findByIndex(index)).thenReturn(Optional.empty());

        FibonacciNumber resultNumber = service.fibonacciNumber(index);

        assertEquals(resultNumber.getValue(), number.getValue());

        verify(repository, times(1)).findByIndex(index);
        verify(calculator, times(1)).getFibonacciNumber(index);
        verify(repository, times(1)).save(resultNumber);
    }
}
