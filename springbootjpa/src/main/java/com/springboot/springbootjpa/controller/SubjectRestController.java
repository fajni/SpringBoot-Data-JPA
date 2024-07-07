package com.springboot.springbootjpa.controller;

import com.springboot.springbootjpa.entity.Subject;
import com.springboot.springbootjpa.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectRestController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String getAllSubjects() {
        return subjectService.getSubjects().toString();
    }

}
