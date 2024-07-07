package com.springboot.springbootjpa.controller;

import com.springboot.springbootjpa.entity.Enrollment;
import com.springboot.springbootjpa.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentRestController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentRestController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/enrollments")
    public String getAllEnrollments() {
        return enrollmentService.getEnrollments().toString();
    }

}
