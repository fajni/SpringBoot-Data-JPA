package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findById(int id);

    Teacher findByFirstname(String firstname);

    Teacher findByFirstnameAndLastname(String firstname, String lastname);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.studentId = ?1")
    int deleteTeacherById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Teacher t SET t.firstname = ?1, t.lastname = ?2, t.email = ?3, t.phone_number = ?4 WHERE t.id = ?5")
    int updateTeacherById(String firstname, String lastname, String email, String phone, int id);
}
