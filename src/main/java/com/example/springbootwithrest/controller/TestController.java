package com.example.springbootwithrest.controller;

import com.example.springbootwithrest.entity.Operation;
import com.example.springbootwithrest.entity.User;
import com.example.springbootwithrest.service.CalcService;
import com.example.springbootwithrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CalcService calcService;

    @Autowired
    private UserService userService;

    @PostMapping("/userSave")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/findUser")
    public User findUser(){
        return new User(1, "Test", "test", "test");
    }

    @PostMapping("/calc")
    public Operation calc(@RequestBody Operation operation){
        Operation calc = calcService.calc(operation);
        return calc;
    }

    @GetMapping("/sortByDate")
    public List<Operation> findOperationByDate(){
        return calcService.findAllHistory();
    }

    @PostMapping("/sortByOperation")
    public List<Operation> findByOperation(String operation){
        return calcService.findHistoryByOperation(operation);
    }

    @PostMapping("/deleteById")
    public void deleteById(int id){
        calcService.delete(id);
    }

    //calc
    //findAllHistory sort by date desc
    //findHistoryByOperation 1. sort by date desc 2. filter by operation
    //deleteOperationById

}
