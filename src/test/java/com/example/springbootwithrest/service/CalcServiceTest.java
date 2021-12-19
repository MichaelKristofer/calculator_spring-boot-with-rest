package com.example.springbootwithrest.service;

import com.example.springbootwithrest.entity.Operation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalcServiceTest {

    CalcService calcService = new CalcService();

    @Test
    void calc() {
        Operation operation = new Operation(2.0, 3.0, "sum", 0, LocalDateTime.now());
        Operation calc = calcService.calc(operation);
        assertEquals(5, calc.getResult());
//        assertEquals(1, calc.getId());
        assertTrue(calcService.findAllHistory().contains(calc));
    }

    @Test
    void sum() {
        double sum = calcService.sum(5, 5);
        assertEquals(10, sum);
    }

    @Test
    void mul() {
        double mul = calcService.mul(5, 5);
        assertEquals(25, mul);
    }

    @Test
    void div() {
        double div = calcService.div(5, 5);
        assertEquals(1, div);
    }

    @Test
    void sub() {
        double sub = calcService.sub(5, 5);
        assertEquals(0, sub);
    }

    @Test
    void findAllHistory() {
        Operation sum = calcService.calc(new Operation(2.0, 3.0, "sum", 0, LocalDateTime.now()));
        Operation mul = calcService.calc(new Operation(6.0, 3.0, "mul", 0, LocalDateTime.now()));
        Operation div = calcService.calc(new Operation(2.0, 19.0, "div", 0, LocalDateTime.now()));
        Operation sub = calcService.calc(new Operation(2.0, 3.0, "sub", 0, LocalDateTime.now()));
        List<Operation> allHistory = calcService.findAllHistory();
        assertEquals(4, allHistory.size());
        assertTrue(allHistory.contains(sum));
        assertTrue(allHistory.contains(mul));
        assertTrue(allHistory.contains(div));
        assertTrue(allHistory.contains(sub));
    }

    @Test
    void findHistoryByOperation() {
        Operation sum = calcService.calc(new Operation(2.0, 3.0, "sum", 0, LocalDateTime.now()));
        Operation mul = calcService.calc(new Operation(6.0, 3.0, "mul", 0, LocalDateTime.now()));
        Operation div = calcService.calc(new Operation(2.0, 19.0, "div", 0, LocalDateTime.now()));
        Operation sub = calcService.calc(new Operation(2.0, 3.0, "sub", 0, LocalDateTime.now()));
        List<Operation> sum1 = calcService.findHistoryByOperation("sum");
        for (Operation operation : sum1) {
            assertEquals(operation.getOperation(), "sum");
        }
    }

    @Test
    void delete() {
        Operation sum = calcService.calc(new Operation(2.0, 3.0, "sum", 0, LocalDateTime.now()));
        Operation mul = calcService.calc(new Operation(6.0, 3.0, "mul", 0, LocalDateTime.now()));
        Operation div = calcService.calc(new Operation(2.0, 19.0, "div", 0, LocalDateTime.now()));
        Operation sub = calcService.calc(new Operation(2.0, 3.0, "sub", 0, LocalDateTime.now()));
        calcService.delete(mul.getId());
        assertFalse(calcService.findAllHistory().contains(mul));
    }
}