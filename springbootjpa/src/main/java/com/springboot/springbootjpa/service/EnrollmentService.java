package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.entity.Enrollment;
import com.springboot.springbootjpa.repository.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final IEnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(IEnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getEnrollments() {
        return enrollmentRepository.findAll();
    }

}
