package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Student;
import com.springboot.springbootjpa.id.StudentId;
import jakarta.persistence.IdClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IStudentRepositoryTest {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Test
    @Disabled("Test is successful only on the first run!")
    public void saveStudentTest(){
        Student student = new Student(new StudentId(237, 2020), "Veljko", "Fajnisevic", "veljko@gmail.com");
        iStudentRepository.save(student);
        assertEquals(iStudentRepository.findAll().getFirst().toString(), student.toString());
    }

    @Test
    public void findStudentByFirstnameAndLastnameTest(){
        List<Student> students = iStudentRepository.findStudentByFirstnameAndLastname("Veljko", "Fajnisevic");
        for(Student s:students){
            System.out.println(s.toString());
        }
    }

    @Test
    public void findStudentByFirstnameAndLastnameContainingTest(){
        List<Student> students = iStudentRepository.findStudentByFirstnameAndLastnameContaining("Ve", "Fa");
        for(Student s:students){
            System.out.println(s.toString());
        }
    }

    @Test
    @Disabled("Test is successful only on the first run!")
    public void findStudentByStudentIdTest(){
        Optional<Student> foundStudent = iStudentRepository.findStudentByStudentId(new StudentId(237, 2020));
        assertTrue(foundStudent.isPresent());
    }

    @Test
    public void getStudentByEmailTest(){
        System.out.println(iStudentRepository.getStudentByEmail("veljko@gmail.com").toString());
        assertEquals(iStudentRepository.getStudentByEmail("veljko@gmail.com").getFirstname(), "Veljko");
    }

    @Test
    public void getStudentIdByEmailTest(){
        System.out.println(iStudentRepository.getStudentByEmail("veljko@gmail.com").getStudentId().getId());
        System.out.println(iStudentRepository.getStudentByEmail("veljko@gmail.com").getStudentId().getAdmission_year());
        assertEquals(iStudentRepository.getStudentByEmail("veljko@gmail.com").getStudentId().getId(), 237);
        assertEquals(iStudentRepository.getStudentByEmail("veljko@gmail.com").getStudentId().getAdmission_year(), 2020);
    }

    @Test
    public void getAllEmails(){
        List<String> emails = iStudentRepository.getAllEmails();
        for(String e:emails){
            System.out.println(e);
        }
        assertTrue(emails.contains("veljko@gmail.com"));
    }

    @Test
    public void getStudentByEmailNativeTest(){
        System.out.println(iStudentRepository.getStudentByEmailNative("veljko@gmail.com").toString());
        assertEquals(iStudentRepository.getStudentByEmailNative("veljko@gmail.com").getFirstname(), "Veljko");
    }

    @Test
    public void updateStudentByStudentIdTest(){
        assertTrue(
                iStudentRepository.updateStudentByStudentId(
                        "Veljko",
                        "Fajnisevic",
                        "veljko@gmail.com",
                        "",
                        new StudentId(237, 2020)
                ) > 0
        );
        System.out.println(iStudentRepository.findById(new StudentId(237, 2020)));
    }

    @Test
    public void deleteStudentByStudentIdTest(){
        assertTrue(iStudentRepository.deleteStudentByStudentId(new StudentId(237, 2020)) > 0);
    }
}