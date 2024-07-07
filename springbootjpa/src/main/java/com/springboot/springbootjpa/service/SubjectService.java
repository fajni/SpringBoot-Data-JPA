package com.springboot.springbootjpa.service;

import com.springboot.springbootjpa.entity.Subject;
import com.springboot.springbootjpa.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final ISubjectRepository subjectRepository;

    @Autowired
    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

}
