package com.example.springbootwithrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @JsonIgnore
    private int id;

    public Operation(double num1, double num2, String operation, double result, LocalDateTime date) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.date = date;
    }

    private double num1;
    private double num2;
    private String operation;
    private double result;
    private LocalDateTime date;

}
