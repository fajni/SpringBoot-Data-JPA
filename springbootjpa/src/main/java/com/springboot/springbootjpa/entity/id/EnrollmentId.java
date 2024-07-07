package com.springboot.springbootjpa.entity.id;

import com.springboot.springbootjpa.entity.Subject;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {

    @Embedded
    private StudentId studentId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_code", referencedColumnName = "code")
    private Subject subject;

    public EnrollmentId() {
    }

    public EnrollmentId(Subject subject, StudentId studentId) {
        this.subject = subject;
        this.studentId = studentId;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public Subject getSubject() {
        return subject;
    }
}
