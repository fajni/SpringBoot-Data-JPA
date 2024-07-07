package com.springboot.springbootjpa.controller;

import com.springboot.springbootjpa.entity.Teacher;
import com.springboot.springbootjpa.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getTeachers();
    }

}
