package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.entity.Student;
import com.springboot.springbootjpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}
