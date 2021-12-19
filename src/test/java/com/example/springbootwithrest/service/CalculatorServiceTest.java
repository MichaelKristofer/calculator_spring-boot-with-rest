package com.example.springbootwithrest.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void sum() {
        CalculatorService calculatorService = new CalculatorService();
        double result = calculatorService.sum(2, 2);
        assertEquals(4, result);

    }
}