package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.entity.Teacher;
import com.springboot.springbootjpa.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final ITeacherRepository teacherRepository;

    @Autowired
    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

}
