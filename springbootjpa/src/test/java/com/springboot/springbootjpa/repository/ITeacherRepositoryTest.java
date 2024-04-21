package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest // data in database won't be impact
class ITeacherRepositoryTest {

    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Test
    public void saveTeacherTest() {
        Teacher teacher = new Teacher("Shabriri", "Dawoodi", "shabriri@gmail.com");
        iTeacherRepository.save(teacher);
        assertEquals(iTeacherRepository.findByFirstname("Shabriri").getFirstname(), "Shabriri");
    }

    @Test
    public void getAllTeachersTest() {
        List<Teacher> teacherList = iTeacherRepository.findAll();
        teacherList.forEach(System.out::println);
        assertFalse(teacherList.isEmpty());
    }

    @Test
    public void deleteTeacherById(){
        assertTrue(iTeacherRepository.deleteTeacherById(3) > 0);
    }

    @Test
    public void updateTeacherById(){
        assertTrue(
                iTeacherRepository.updateTeacherById(
                        "Veljko",
                        "Fajnisevic",
                        "veljko@gmail.com",
                        "123",
                        3
                ) > 0
        );
    }

}