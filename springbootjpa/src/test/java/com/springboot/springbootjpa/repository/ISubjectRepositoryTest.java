package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Subject;
import com.springboot.springbootjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ISubjectRepositoryTest {

    @Autowired
    private ISubjectRepository iSubjectRepository;

    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Test
    public void saveSubjectTest(){

        Teacher teacher = iTeacherRepository.findByFirstname("Shabriri");
        System.out.println(teacher.toString());

        Subject subject = new Subject("DSA", teacher);

        iSubjectRepository.save(subject);
    }

    @Test
    public void saveSubjectFailTest(){
        //Teacher teacher = new Teacher("Tomas", "Shelby", "tomas@gmail.com");
        Teacher teacher = new Teacher();

        Subject subject = new Subject("Math", teacher);
        try {
            iSubjectRepository.save(subject); // can't save subject if there's no available teacher
        } catch (Exception e){
            fail("Can't save subject if there's not teacher available!");
        }
    }

    @Test
    public void deleteSubjectByIdTest(){
        iSubjectRepository.deleteById(1L);
    }

    @Test
    public void updateSubjectTitleByIdTest(){
        assertTrue(
                iSubjectRepository.updateSubjectTitleById("Algorithms", 5L) > 0
        );
    }

    @Test
    public void updateSubjectTeacherByIdTest(){

        Teacher teacher = iTeacherRepository.findByFirstname("Shabriri");

        assertTrue(
                iSubjectRepository.updateSubjectTeacherById(teacher,5L) > 0
        );
    }

    @Test
    public void getAllSubjectsTest(){
        List<Subject> subjects = iSubjectRepository.findAll();

        for(Subject s:subjects){
            System.out.println(s.toString());
        }
    }

    @Test
    public void getSubjectById(){
        Subject subject = iSubjectRepository.getSubjectByCode(99L);
        System.out.println(subject.toString());
    }

}