package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Enrollment;
import com.springboot.springbootjpa.id.EnrollmentId;
import com.springboot.springbootjpa.id.StudentId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM enrollment e WHERE e.subject_code = ?1", nativeQuery = true)
    int deleteEnrollmentBySubjectCode(Long code);

}
