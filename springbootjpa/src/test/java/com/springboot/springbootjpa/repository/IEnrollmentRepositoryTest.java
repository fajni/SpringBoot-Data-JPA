package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Enrollment;
import com.springboot.springbootjpa.entity.Student;
import com.springboot.springbootjpa.entity.Subject;
import com.springboot.springbootjpa.entity.id.EnrollmentId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IEnrollmentRepositoryTest {

    @Autowired
    private IEnrollmentRepository iEnrollmentRepository;

    @Autowired
    private ISubjectRepository iSubjectRepository;

    @Autowired
    private IStudentRepository iStudentRepository;

    @Test
    public void getAllEnrollmentsTest(){
        assertFalse(iEnrollmentRepository.findAll().isEmpty());
    }

    @Test
    public void saveEnrollmentTest(){
        Subject subject = iSubjectRepository.getSubjectByCode(99L);
        System.out.println(subject.toString());
        Student student = iStudentRepository.getStudentByEmail("veljko@gmail.com");
        iEnrollmentRepository.save(new Enrollment(
                new EnrollmentId(subject, student.getStudentId()),
                Date.valueOf("2024-01-01")
        ));
    }

    @Test
    public void deleteEnrollmentTest(){
        iEnrollmentRepository.deleteEnrollmentBySubjectCode(99L);
    }

}