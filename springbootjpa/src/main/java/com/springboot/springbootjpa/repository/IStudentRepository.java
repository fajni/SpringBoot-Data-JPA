package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Student;
import com.springboot.springbootjpa.entity.id.StudentId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, StudentId> {

    List<Student> findStudentByFirstnameAndLastname(String firstname, String lastname);

    List<Student> findStudentByFirstnameAndLastnameContaining(String firstname, String lastname);

    Optional<Student> findStudentByStudentId(StudentId id);

    // JPQL - query on classes
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student getStudentByEmail(String email);

    //Native Named Param
    @Query("SELECT s.studentId FROM Student s WHERE s.email = :email") // classes
    Student getStudentIdByEmail(@Param("email") String email);

    @Query("SELECT s.email FROM Student s")
    List<String> getAllEmails();

    //Native Query
    @Query(
            value = "SELECT * FROM student s WHERE s.email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailNative(String email);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.firstname = ?1, s.lastname = ?2, s.email = ?3, s.phone_number = ?4 WHERE s.studentId = ?5")
    int updateStudentByStudentId(String firstname, String lastname, String email, String phone, StudentId id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.studentId = ?1")
    int deleteStudentByStudentId(StudentId id);

}
