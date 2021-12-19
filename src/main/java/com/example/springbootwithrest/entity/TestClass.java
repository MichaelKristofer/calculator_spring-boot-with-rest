package com.example.springbootwithrest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestClass implements Comparable{
    private String name;
    private String lastName;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
