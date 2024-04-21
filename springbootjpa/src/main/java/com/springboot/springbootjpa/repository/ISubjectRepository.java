package com.springboot.springbootjpa.repository;

import com.springboot.springbootjpa.entity.Subject;
import com.springboot.springbootjpa.entity.Teacher;
import com.springboot.springbootjpa.id.StudentId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {

    Subject getSubjectByCode(Long code);

    @Modifying
    @Transactional
    @Query("UPDATE Subject s SET s.title = ?1 WHERE s.id = ?2")
    int updateSubjectTitleById(String title, Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Subject s SET s.teacher = ?1 WHERE s.id = ?2")
    int updateSubjectTeacherById(Teacher teacher, Long id);

}
