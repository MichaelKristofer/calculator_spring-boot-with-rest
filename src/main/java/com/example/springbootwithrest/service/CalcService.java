package com.example.springbootwithrest.service;

import com.example.springbootwithrest.entity.Operation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalcService {

    private List<Operation> operations = new ArrayList<>();
    private int count = 0;


    public Operation calc(Operation operation){
        switch (operation.getOperation()){
            case "sum":
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                break;
            case "mul":
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                break;
            case "div":
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                break;
            case "sub":
                operation.setResult(sub(operation.getNum1(), operation.getNum2()));
                break;
        }
        operation.setId(++count);
        operation.setDate(LocalDateTime.now());
        operations.add(operation);
        return operation;
    }


    public double sum(double a, double b){
        return a + b;
    }

    public double mul(double a, double b){
        return a * b;
    }

    public double div(double a, double b){
        return a / b;
    }

    public double sub(double a, double b){
        return a - b;
    }

    public List<Operation> findAllHistory(){
        List<Operation> collect = operations
                .stream()
                .sorted(Comparator.comparing(Operation::getDate).reversed())
                .collect(Collectors.toList());
        return collect;
    }

    public List<Operation> findHistoryByOperation(String operation){
        List<Operation> collect = operations.stream()
                .filter(operation1 -> operation1.getOperation().equals(operation))
                .sorted(Comparator.comparing(Operation::getDate))
                .collect(Collectors.toList());
        return collect;
    }

    public void delete(int id){
        List<Operation> collect = operations.stream()
                .filter(operation -> operation.getId() == id)
                .collect(Collectors.toList());
        operations.remove(collect.get(0));

    }
}