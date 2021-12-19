package com.example.springbootwithrest.service;

import com.example.springbootwithrest.entity.TestClass;
import com.example.springbootwithrest.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<User> userList = new ArrayList<>();

    public void save(User user){
        userList.add(user);
    }


    //info
    //debug
    //warn
    //error
    //trace
    public List<User> sortByUsernameAndName(){
        log.info("Use this method");
        return userList.stream()
                .sorted(Comparator.comparing(User::getName))
                .sorted((o1, o2) -> o1.getUsername().compareToIgnoreCase(o2.getUsername()))
                .collect(Collectors.toList());
    }

    public void asd(){
    List<TestClass> testClassList = new ArrayList<>();
        List<TestClass> collect = testClassList.stream()
                .sorted(Comparator.comparing(TestClass::getName, String.CASE_INSENSITIVE_ORDER).thenComparing((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName())))
                .sorted((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()))
                .collect(Collectors.toList());
    }


}
