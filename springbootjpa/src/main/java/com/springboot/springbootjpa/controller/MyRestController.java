package com.springboot.springbootjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    public Map<String, String> map = Map.of(
            "/enrollment", "Get All Enrollments",
            "/students", "Get All Students",
            "/subjects", "Get All Subjects",
            "/teachers", "Get All Teachers"
    );

    @GetMapping
    public Map hello() {
        return map;
    }
}
