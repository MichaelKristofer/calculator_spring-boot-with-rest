package com.example.springbootwithrest;

import com.example.springbootwithrest.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootWithRestApplicationTests {

    @Autowired
    CalcService calcService;

    @Test
    void contextLoads() {
    }

}
